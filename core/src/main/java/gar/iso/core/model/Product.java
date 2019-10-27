package gar.iso.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Gor on 11/19/2017.
 */
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "product_type",
            foreignKey = @ForeignKey(name = "fk_productType"))
    private ProductType productType;

    @Column(name = "product_lang_id")
    private int productLangId;

    @Column(name = "product_code")
    private String code;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_name_en")
    @NotBlank(message = "error.message.add.property.english")
    private String productNameEn;

    @Column(name = "product_name_ru")
    @NotBlank(message = "error.message.add.property.russian")
    private String productNameRu;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_desc_en")
    @NotBlank(message = "error.message.add.property.english")
    private String productDescriptionEn;

    @Column(name = "product_desc_ru")
    @NotBlank(message = "error.message.add.property.russian")
    private String productDescriptionRu;


    @Column(name = "unit_price")
    @Min(value = 1, message = "error.message.min.length")
    private int unitPrice;

//    private int quantity;

    @Column(name = "product_is_active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "product_category_type_id",
            foreignKey = @ForeignKey(name = "fk_productCategoryTypeId"))
    private CategoryType productCategoryType;

    @ManyToOne
    @JoinColumn(name = "product_user_id",
            foreignKey = @ForeignKey(name = "fk_productUserId"))
    private User productUser;

//    private int purchases;

    private int views;

    @Transient
    private MultipartFile file;

//    Default construtor to initialize product code by UUID from java.util package
    public Product(){
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }


    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getProductLangId() {
        return productLangId;
    }

    public void setProductLangId(int productLangId) {
        this.productLangId = productLangId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNameEn() {
        return productNameEn;
    }

    public void setProductNameEn(String productNameEn) {
        this.productNameEn = productNameEn;
    }

    public String getProductNameRu() {
        return productNameRu;
    }

    public void setProductNameRu(String productNameRu) {
        this.productNameRu = productNameRu;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescriptionEn() {
        return productDescriptionEn;
    }

    public void setProductDescriptionEn(String productDescriptionEn) {
        this.productDescriptionEn = productDescriptionEn;
    }

    public String getProductDescriptionRu() {
        return productDescriptionRu;
    }

    public void setProductDescriptionRu(String productDescriptionRu) {
        this.productDescriptionRu = productDescriptionRu;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryType getProductCategoryType(){
        return productCategoryType;
    }

    public void setProductCategoryType(CategoryType productCategoryType) {
        this.productCategoryType = productCategoryType;
    }

    public User getProductUser() {
        return productUser;
    }

    public void setProductUser(User productUser) {
        this.productUser = productUser;
    }

//    public int getPurchases() {
//        return purchases;
//    }
//
//    public void setPurchases(int purchases) {
//        this.purchases = purchases;
//    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hash(productType, productLangId, code, productName, productNameEn, productNameRu, productDescription, productDescriptionEn, productDescriptionRu, unitPrice, active, productCategoryType, productUser, views, file);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.productType, other.productType)
                && Objects.equals(this.productLangId, other.productLangId)
                && Objects.equals(this.code, other.code)
                && Objects.equals(this.productName, other.productName)
                && Objects.equals(this.productNameEn, other.productNameEn)
                && Objects.equals(this.productNameRu, other.productNameRu)
                && Objects.equals(this.productDescription, other.productDescription)
                && Objects.equals(this.productDescriptionEn, other.productDescriptionEn)
                && Objects.equals(this.productDescriptionRu, other.productDescriptionRu)
                && Objects.equals(this.unitPrice, other.unitPrice)
                && Objects.equals(this.active, other.active)
                && Objects.equals(this.productCategoryType, other.productCategoryType)
                && Objects.equals(this.productUser, other.productUser)
                && Objects.equals(this.views, other.views)
                && Objects.equals(this.file, other.file);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("productType", productType)
                .append("productLangId", productLangId)
                .append("code", code)
                .append("productName", productName)
                .append("productNameEn", productNameEn)
                .append("productNameRu", productNameRu)
                .append("productDescription", productDescription)
                .append("productDescriptionEn", productDescriptionEn)
                .append("productDescriptionRu", productDescriptionRu)
                .append("unitPrice", unitPrice)
                .append("active", active)
                .append("productCategoryType", productCategoryType)
                .append("productUser", productUser)
                .append("views", views)
                .append("file", file)
                .toString();
    }
}
