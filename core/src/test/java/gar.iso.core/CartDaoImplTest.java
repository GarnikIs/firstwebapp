package gar.iso.core;

import gar.iso.core.dao.CartDao;
import gar.iso.core.dao.CartLineDao;
import gar.iso.core.dao.ProductDao;
import gar.iso.core.dao.UserDao;
import gar.iso.core.dto.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gor on 12/3/2017.
 */
public class CartDaoImplTest {

    private static AnnotationConfigApplicationContext context;
    private static UserDao userDao;
    private static CartDao cartDao;
    private User user = null;
    private Cart cart = null;

    /**
     * Initializing AnnotationConfigApplicationContext and userDao
     */
    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("gar.iso.core");
        context.refresh();
        userDao = (UserDao) context.getBean("userDao");
        cartDao = (CartDao) context.getBean("cartDao");
    }

    /**
     * test add cart
     * @asserts true or false
     */
    @Test
    public void testAddUserCartByCart() {
        user = userDao.getUserByUserId(3);
        cart = new Cart();
        cart.setCartUser(user);
        cart.setCartLines(5);
        cart.setGrandTotal(50000);

        assertEquals("Failed to add cart", true, cartDao.addUserCartByCart(cart));
    }

    /**
     * test updating cart
     * @asserts true or false
     */
    @Test
    public void testUpdateCartByCart() {
        user = userDao.getUserByUserId(3);
        cart = user.getCart();
        cart.setCartUser(user);
        cart.setCartLines(111);
        cart.setGrandTotal(1100000);

        assertEquals("Failed to add cart", true, cartDao.updateCartByCart(cart));
    }

/**
     * test getting cart by user id
     * @asserts cart
     */
    @Test
    public void testGetCartByUserId() {
        user = userDao.getUserByUserId(3);
        cart = user.getCart();
        Cart cart1 = cartDao.getCartByUserId(user.getUserId());

        assertEquals("Failed to get cart", cart.getCartLines(), cart1.getCartLines());
        assertEquals("Failed to get cart", cart.getCartId(), cart1.getCartId());
        assertEquals("Failed to get cart", cart.getGrandTotal(), cart1.getGrandTotal(), 0.0f);
        assertEquals("Failed to get cart", cart.getCartUser().getUserId(),
                                                    cart1.getCartUser().getUserId());
    }

}
