package gar.iso.core.dao;

import gar.iso.core.dto.Cart;
import gar.iso.core.dto.CartLine;

import java.util.List;

/**
 * Created by Gor on 12/3/2017.
 */
public interface CartLineDao {

    boolean addCartLine(CartLine cartLine);

    boolean updateCartLine(CartLine cartLine);

    boolean deleteCartLine(CartLine cartLine);

    CartLine getCartLine(int cartLineId);

    List<CartLine> getListOfCartLines(int cartId);

    List<CartLine> getListOfAvailableCartLines(int cartId);

    CartLine getByCartIdAndProductId(int cartId, int productId);

    /**
     * updates cart
     * @param cart
     * @return true or false
     */
    boolean updateCart(Cart cart);

}
