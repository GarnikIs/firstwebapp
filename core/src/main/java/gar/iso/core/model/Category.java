package gar.iso.core.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gor on 11/17/2017.
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

//    category id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

//    category type
    @ManyToOne
    @JoinColumn(name = "category_type",
            foreignKey = @ForeignKey(name = "fk_categoryType"))
    private CategoryType categoryType;

//    language id
    @Column(name = "category_lang_id")
    private int categoryLangId;

//    single category name
    @Column(name = "category_name")
    private String categoryName;

//    list category name in English
    @Transient
    @NotBlank(message = "error.message.add.property.english")
    private String categoryNameEn;

//    list category name in Russian
    @Transient
    @NotBlank(message = "error.message.add.property.russian")
    private String categoryNameRu;



    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public int getCategoryLangId() {
        return categoryLangId;
    }

    public void setCategoryLangId(int categoryLangId) {
        this.categoryLangId = categoryLangId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryNameEn() {
        return categoryNameEn;
    }

    public void setCategoryNameEn(String categoryNameEn) {
        this.categoryNameEn = categoryNameEn;
    }

    public String getCategoryNameRu() {
        return categoryNameRu;
    }

    public void setCategoryNameRu(String categoryNameRu) {
        this.categoryNameRu = categoryNameRu;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryNameEn='" + categoryNameEn + '\'' +
                ", categoryNameRu='" + categoryNameRu + '\'' +
                '}';
    }
}
