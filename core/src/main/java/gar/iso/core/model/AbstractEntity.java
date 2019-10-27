package gar.iso.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequence_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated")
    private LocalDateTime updatedTime;

    @Column(name = "removed")
    private LocalDateTime deletedTime;

    public AbstractEntity() {
        super();
    }

    @PrePersist
    protected void onCreate() {
        createdTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdTime, updatedTime, deletedTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.createdTime, other.createdTime)
                && Objects.equals(this.updatedTime, other.updatedTime)
                && Objects.equals(this.deletedTime, other.deletedTime);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createdTime", createdTime)
                .append("updatedTime", updatedTime)
                .append("deletedTime", deletedTime)
                .toString();
    }
}
