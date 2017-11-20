package gar.iso.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Gor on 11/19/2017.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_code")
    private String code;

    @Column(name = "product_name")
    private String name;

    private String brand;

    @JsonIgnore
    @Column(name = "product_description")
    private String description;

    @Column(name = "unit_price")
    private int unitPrice;

    private int quantity;

    @JsonIgnore
    @Column(name = "product_is_active")
    private boolean active;

    @JsonIgnore
    @Column(name = "product_category_id")
    private int productCategoryId;

    @JsonIgnore
    @Column(name = "product_supplier_id")
    private int productSupplierId;

    private int purchase;

    private int views;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public int getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(int productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", active=" + active +
                ", productCategoryId=" + productCategoryId +
                ", productSupplierId=" + productSupplierId +
                ", purchase=" + purchase +
                ", views=" + views +
                '}';
    }
}
