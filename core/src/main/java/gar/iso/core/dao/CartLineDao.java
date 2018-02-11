//package gar.iso.core.dao;
//
//import gar.iso.core.dto.Cart;
//import gar.iso.core.dto.CartLine;
//
//import java.util.List;
//
///**
// * Created by Gor on 12/3/2017.
// */
//public interface CartLineDao {
//
//    /**
//     * adds cartLine
//     * @param cartLine
//     * @return true or false
//     */
//    boolean addCartLine(CartLine cartLine);
//
//    /**
//     * updates cartLine
//     * @param cartLine
//     * @return true or false
//     */
//    boolean updateCartLine(CartLine cartLine);
//
//    /**
//     * deletes cartLine
//     * @param cartLine
//     * @return true or false
//     */
//    boolean deleteCartLine(CartLine cartLine);
//
//    /**
//     * gets cartLine by cartline id
//     * @param cartLineId
//     * @return true or false
//     */
//    CartLine getCartLine(int cartLineId);
//
//    /**
//     * gets list of cartLines
//     * @param cartId
//     * @return true or false
//     */
//    List<CartLine> getListOfCartLines(int cartId);
//
//    /**
//     * gets list of available cartlines
//     * @param cartId
//     * @return true or false
//     */
//    List<CartLine> getListOfAvailableCartLines(int cartId);
//
//    /**
//     * gets single cartline
//     * @param cartId
//     * @param productId
//     * @return true or false
//     */
//    CartLine getByCartIdAndProductId(int cartId, int productId);
//
//}
