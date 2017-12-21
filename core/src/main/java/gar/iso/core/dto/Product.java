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

    @Column(name = "product_code")
    private String code;

    @Column(name = "product_name")
    @NotBlank(message = "Please enter product name")
    private String productName;

    @NotBlank(message = "Please enter product brand")
    private String brand;

    @JsonIgnore
    @Column(name = "product_description")
    @NotBlank(message = "Please enter description for product")
    private String productDescription;

    @Column(name = "unit_price")
    @Min(value = 1, message = "Price cannot be less than 1")
    private int unitPrice;

    private int quantity;

    @Column(name = "product_is_active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "product_category_id",
            foreignKey = @ForeignKey(name = "fk_productCategoryId"))
    private Category productCategory;

    @ManyToOne
    @JoinColumn(name = "product_user_id",
            foreignKey = @ForeignKey(name = "fk_productUserId"))
    private User productUser;

    private int purchases;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getProductCategory(){
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public User getProductUser() {
        return productUser;
    }

    public void setProductUser(User productUser) {
        this.productUser = productUser;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

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
                ", name='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + productDescription + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", active=" + active +
                ", productCategoryId=" + ((productCategory == null) ? "Not Selected" : productCategory.getCategoryId()) +
                ", productUserId=" + ((productUser == null) ? "Not Authorized" : productUser.getUserId()) +
                ", purchase=" + purchases +
                ", views=" + views +
                '}';
    }
}
