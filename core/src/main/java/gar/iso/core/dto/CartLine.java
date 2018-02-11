//package gar.iso.core.dto;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * Created by Gor on 12/3/2017.
// */
//@Entity
//@Table(name = "cart_line")
//public class CartLine  implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cartline_id")
//    private int cartLineId;
//
//    @OneToOne
//    @JoinColumn(name = "cartline_product_id",
//            foreignKey = @ForeignKey(name = "fk_cartlineProductId"))
//    private Product product;
//
//    @Column(name = "cartline_cart_id")
//    private int cartLineCartId;
//
//    @Column(name = "cartline_product_count")
//    private int cartLineProductCount;
//
//    @Column(name = "cartline_total")
//    private double cartLineTotal;
//
//    @Column(name = "buying_price")
//    private double buyingPrice;
//
//    @Column(name = "is_available")
//    private boolean available = true;
//
//    public int getCartLineId() {
//        return cartLineId;
//    }
//
//    public void setCartLineId(int cartLineId) {
//        this.cartLineId = cartLineId;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public int getCartLineCartId() {
//        return cartLineCartId;
//    }
//
//    public void setCartLineCartId(int cartLineCartId) {
//        this.cartLineCartId = cartLineCartId;
//    }
//
//    public int getCartLineProductCount() {
//        return cartLineProductCount;
//    }
//
//    public void setCartLineProductCount(int cartLineProductCount) {
//        this.cartLineProductCount = cartLineProductCount;
//    }
//
//    public double getCartLineTotal() {
//        return cartLineTotal;
//    }
//
//    public void setCartLineTotal(double cartLineTotal) {
//        this.cartLineTotal = cartLineTotal;
//    }
//
//    public double getBuyingPrice() {
//        return buyingPrice;
//    }
//
//    public void setBuyingPrice(double buyingPrice) {
//        this.buyingPrice = buyingPrice;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//
//    @Override
//    public String toString() {
//        return "CartLine{" +
//                "cartLineId=" + cartLineId +
//                ", productId=" + product.getProductId() +
//                ", cartLineCartId=" + cartLineCartId +
//                ", cartLineProductCount=" + cartLineProductCount +
//                ", cartLineTotal=" + cartLineTotal +
//                ", buyingPrice=" + buyingPrice +
//                ", available=" + available +
//                '}';
//    }
//}
