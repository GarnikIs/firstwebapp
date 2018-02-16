package gar.iso.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Gor on 11/19/2017.
 */
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code='" + code + '\'' +
                ", nameEn='" + productNameEn + '\'' +
                ", nameRu='" + productNameRu + '\'' +
                ", descriptionEn='" + productDescriptionEn + '\'' +
                ", descriptionRu='" + productDescriptionRu + '\'' +
                ", unitPrice=" + unitPrice +
                ", active=" + active +
                ", productCategoryId=" + ((productCategoryType == null) ? "Not Selected" : productCategoryType.getCategoryTypeId()) +
                ", productUserId=" + ((productUser == null) ? "Not Authorized" : productUser.getUserId()) +
//                ", purchase=" + purchases +
                ", views=" + views +
                '}';
    }
}
