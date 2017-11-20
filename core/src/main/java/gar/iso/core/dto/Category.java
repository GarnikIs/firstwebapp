package gar.iso.core.dto;

import javax.persistence.*;

/**
 * Created by Gor on 11/17/2017.
 */
@Entity
public class Category {

//    category id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

//    category name
    @Column(name = "category_name")
    private String name;

//    category description
    @Column(name = "category_description")
    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isActive=" + active +
                '}';
    }
}
