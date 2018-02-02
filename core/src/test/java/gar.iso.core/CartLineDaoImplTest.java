//package gar.iso.core;
//
//import gar.iso.core.dao.CartDao;
//import gar.iso.core.dao.CartLineDao;
//import gar.iso.core.dao.ProductDao;
//import gar.iso.core.dao.UserDao;
//import gar.iso.core.dto.*;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by Gor on 12/3/2017.
// */
//public class CartLineDaoImplTest {
//
//    private static AnnotationConfigApplicationContext context;
//    private static ProductDao productDao;
//    private static UserDao userDao;
//    private static CartLineDao cartLineDao;
//    private static CartDao cartDao;
//    private User user = null;
//    private Product product = null;
//    private UserAddress address = null;
//    private Cart cart = null;
//    private CartLine cartLine = null;
//
//    /**
//     * Initializing AnnotationConfigApplicationContext and userDao
//     */
//    @BeforeClass
//    public static void init() {
//        context = new AnnotationConfigApplicationContext();
//        context.scan("gar.iso.core");
//        context.refresh();
//        cartLineDao = (CartLineDao) context.getBean("cartLineDao");
//        productDao = (ProductDao) context.getBean("productDao");
//        userDao = (UserDao) context.getBean("userDao");
//        cartDao = (CartDao) context.getBean("cartDao");
//    }
//
//
//
//    /**
//     * test updating cart
//     * @asserts true or false
//     */
//    @Test
//    public void testUpdateCart() {
//
//        user = userDao.getUserByUserId(3);
//        product = productDao.getProductById(2);
//        cart = user.getCart();
//
//        cartLine = new CartLine();
//        cartLine.setProduct(product);
//        cartLine.setCartLineCartId(cart.getCartId());
//        cartLine.setCartLineProductCount(cartLine.getCartLineProductCount() + 1);
//        cartLine.setBuyingPrice(product.getUnitPrice());
//        cartLine.setCartLineTotal(cartLine.getCartLineProductCount()* product.getUnitPrice());
//        cartLine.setAvailable(true);
//
//        assertEquals("Failed to add cart line", true, cartLineDao.addCartLine(cartLine));
//        cart.setCartLines(cart.getCartLines() + 1);
//        cart.setGrandTotal(cart.getGrandTotal() + cartLine.getCartLineTotal());
//        assertEquals("Failed to add cart line", true, cartDao.updateCartByCart(cart));
//    }
//}
