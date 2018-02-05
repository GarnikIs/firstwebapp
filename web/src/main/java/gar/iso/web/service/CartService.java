package gar.iso.web.service;

import gar.iso.core.dao.CartDao;
import gar.iso.core.dao.CartLineDao;
import gar.iso.core.dao.ProductDao;
import gar.iso.core.dto.Cart;
import gar.iso.core.dto.CartLine;
import gar.iso.core.dto.Product;
import gar.iso.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Gor on 12/4/2017.
 */
@Service("cartService")
public class CartService {

    @Autowired
    private CartLineDao cartLineDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private HttpSession session;

//    Cart of the logged in user
    private Cart getCart() {
        return ((UserModel)session.getAttribute("userModel")).getCart();
    }

//    CartLines of logged in user's cart
    public List<CartLine> getCartLineList() {
        return cartLineDao.getListOfCartLines(this.getCart().getCartId());
    }

//    Adding product to cartLine of logged in user's cart
    public String addCartLineProduct(int productId) {
        Cart cart = this.getCart();
        CartLine cartLine = cartLineDao.getByCartIdAndProductId(cart.getCartId(), productId);
        Product product = productDao.getProductById(productId, 1);
        if (cartLine == null) {
            cartLine = new CartLine();
            cartLine.setCartLineCartId(cart.getCartId());
            cartLine.setProduct(product);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setCartLineTotal(product.getUnitPrice());
            cartLine.setCartLineProductCount(cartLine.getCartLineProductCount() + 1);
            cartLine.setAvailable(true);

            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getCartLineTotal());
            cart.setCartLines(cart.getCartLines() + 1);

            cartLineDao.addCartLine(cartLine);
            cartDao.updateCartByCart(cart);

            return "result=added";
        } else {
            double oldTotalAmount = cartLine.getCartLineTotal();
            cartLine.setCartLineProductCount(cartLine.getCartLineProductCount() + 1);
            cartLine.setCartLineTotal(cartLine.getCartLineProductCount() * product.getUnitPrice());

            cart.setGrandTotal(cart.getGrandTotal() - oldTotalAmount + cartLine.getCartLineTotal());
            cart.setCartLines(cart.getCartLines() + 1);

            cartLineDao.updateCartLine(cartLine);
            cartDao.updateCartByCart(cart);

            return "result=added";
        }
    }

//    Update cartLine of logged in user's cart
    public String updateCartLineProduct(int cartLineId, int productNewCount) {
        CartLine cartLine = cartLineDao.getCartLine(cartLineId);
        if (cartLine == null) {
            return "result=error";
        } else {
            Product product = cartLine.getProduct();
            double oldTotalAmount = cartLine.getCartLineTotal();

//            if (product.getQuantity() <= productNewCount) {
//                productNewCount = product.getQuantity();
//            }
            cartLine.setCartLineProductCount(productNewCount);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setCartLineTotal(productNewCount * product.getUnitPrice());
            cartLineDao.updateCartLine(cartLine);

            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - oldTotalAmount + cartLine.getCartLineTotal());
            cartDao.updateCartByCart(cart);
            return "result=updated";
        }
    }

//    Delete product from cartLine of logged in user's cart
    public String deleteCartLineProduct(int cartLineId) {
        CartLine cartLine = cartLineDao.getCartLine(cartLineId);
        if (cartLine == null) {
            return "result=error";
        } else {
            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - cartLine.getCartLineTotal());
            cart.setCartLines(cart.getCartLines() - 1);
            cartLineDao.deleteCartLine(cartLine);
            cartDao.updateCartByCart(cart);
            return "result=deleted";
        }
    }

}
