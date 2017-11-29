package gar.iso.core.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gor on 11/17/2017.
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

//    category id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

//    category name
    @Column(name = "category_name")
    private String categoryName;

//    category description
    @Column(name = "category_description")
    private String categoryDescription;

//    image url of category
    @Column(name = "category_image_url")
    private String imageUrl;

//    ensures category is active/inactive
    @Column(name = "category_is_active")
    private boolean active = true;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", name='" + categoryName + '\'' +
                ", description='" + categoryDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isActive=" + active +
                '}';
    }
}
