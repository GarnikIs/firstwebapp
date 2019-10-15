package gar.iso.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "category_type")
public class CategoryType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_type_id")
    private int categoryTypeId;

    @Column(name = "category_type_name")
    private String categoryTypeName;

    public int getCategoryTypeId() {
        return categoryTypeId;
    }

    public void setCategoryTypeId(int categoryTypeId) {
        this.categoryTypeId = categoryTypeId;
    }

    public String getCategoryTypeName() {
        return categoryTypeName;
    }

    public void setCategoryTypeName(String categoryTypeName) {
        this.categoryTypeName = categoryTypeName;
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "categoryTypeId=" + categoryTypeId +
                ", categoryTypeName='" + categoryTypeName +
                '}';
    }
}
