package gar.iso.core.dao;

import gar.iso.core.dto.Cart;
import gar.iso.core.dto.CartLine;

import java.util.List;

/**
 * Created by Gor on 12/3/2017.
 */
public interface CartDao {

    /**
     * add cart for user if somehow it was not created registration time
     * @param cart
     * @return true or false
     */
    boolean addUserCartByCart(Cart cart);

    /**
     * updates cart
     * @param cart
     * @return true or false
     */
    boolean updateCartByCart(Cart cart);

    /**
     * returns existing cart for user
     * @param userId
     * @return cart
     */
    Cart getCartByUserId(int userId);
}
