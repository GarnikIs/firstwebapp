package gar.iso.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Gor on 11/17/2017.
 */
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

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
        return new ToStringBuilder(this)
                .append("categoryType", categoryType)
                .append("categoryLangId", categoryLangId)
                .append("categoryName", categoryName)
                .append("categoryNameEn", categoryNameEn)
                .append("categoryNameRu", categoryNameRu)
                .toString();
    }
}
