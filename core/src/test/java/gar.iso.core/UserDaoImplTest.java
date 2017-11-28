package gar.iso.core;

import gar.iso.core.dao.UserDao;
import gar.iso.core.dto.Cart;
import gar.iso.core.dto.User;
import gar.iso.core.dto.UserAddress;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gor on 11/18/2017.
 */
public class UserDaoImplTest {

    private static AnnotationConfigApplicationContext context;
    private static UserDao userDao;
    private User user = null;
    private UserAddress address = null;
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
    }

    /**
     * test adding new user
     * @asserts true or false
     */
    @Test
    public void testAddNewUser() {
        user = new User();
        user.setFirstName("Aram");
        user.setLastName("Ishkhan");
        user.setEmail("aramishkhan@gmail.com");
        user.setPhoneNumber("12345");
        user.setRole("USER");
        user.setEnabled(true);
        user.setPassword("123");

        if (user.getRole().equals("USER")) {
            cart = new Cart();
            cart.setCartUser(user);
            user.setCart(cart);
        }
        assertEquals("Failed to add new user", true, userDao.addNewUser(user));
    }

    /**
     * test getting the existing user by user id
     * @asserts true or false
     */
    @Test
    public void testGetUserByUserId() {
        user = new User();
        user.setFirstName("Aram");
        user.setLastName("Ishkhan");
        user.setEmail("aramishkhan@gmail.com");
        user.setPhoneNumber("12345");
        user.setRole("USER");
        user.setEnabled(true);
        user.setPassword("123");

        if (user.getRole().equals("USER")) {
            cart = new Cart();
            cart.setCartUser(user);
            user.setCart(cart);
        }
        userDao.addNewUser(user);
        assertEquals("Failed to fetch user by userId", user.getEmail(), userDao.getUserByUserId(user.getUserId()).getEmail());
    }

    /**
     * test getting the existing user by email and password
     * @asserts true or false
     */
    @Test
    public void testGetUserByEmailAndPassword() {
        user = new User();
        user.setFirstName("Aram");
        user.setLastName("Ishkhan");
        user.setEmail("aramishkhan@gmail.com");
        user.setPhoneNumber("12345");
        user.setRole("USER");
        user.setEnabled(true);
        user.setPassword("123");

        if (user.getRole().equals("USER")) {
            cart = new Cart();
            cart.setCartUser(user);
            user.setCart(cart);
        }
        userDao.addNewUser(user);

        assertEquals("Failed to fetch the user by email", user.getEmail(),
                userDao.getUserByEmailAndPassword("aramishkhan@gmail.com", "123").getEmail());
    }

    /**
     * test updating cart
     * @asserts true or false
     */@Test
    public void testUpdateCart() {
        user = new User();
        user.setFirstName("Aram");
        user.setLastName("Ishkhan");
        user.setEmail("aramishkhan@gmail.com");
        user.setPhoneNumber("12345");
        user.setRole("USER");
        user.setEnabled(true);
        user.setPassword("123");

        if (user.getRole().equals("USER")) {
            cart = new Cart();
            cart.setCartUser(user);
            user.setCart(cart);
        }
        userDao.addNewUser(user);

        user = userDao.getUserByEmailAndPassword("aramishkhan@gmail.com", "123");
        cart = user.getCart();
        cart.setGrandTotal(11111);
        cart.setCartLines(3);

        assertEquals("Failed to update the user's cart", true, userDao.updateCart(cart));
    }



    /**
     * test adding user's address
     * @asserts true or false
     */
    @Test
    public void testAddUserAddress() {
        user = new User();
        user.setFirstName("Aram");
        user.setLastName("Ishkhan");
        user.setEmail("aramishkhan@gmail.com");
        user.setPhoneNumber("12345");
        user.setRole("USER");
        user.setEnabled(true);
        user.setPassword("123");

        if (user.getRole().equals("USER")) {
            cart = new Cart();
            cart.setGrandTotal(25555);
            cart.setCartLines(3);
            cart.setCartUser(user);
            user.setCart(cart);
        }
        address = new UserAddress();
        address.setAddressLine("Komitas");
        address.setCity("Yerevan");
        address.setState("Not available");
        address.setCountry("Armenia");
        address.setZipCode("0025");
        address.setBilling(true);
        address.setUser(user);

        assertEquals("Failed to add the new user", true, userDao.addNewUser(user));
        assertEquals("Failed to add the billing address", true, userDao.addUserAddress(address));

        address = new UserAddress();
        address.setAddressLine("Avan");
        address.setCity("Yerevan");
        address.setState("Not available");
        address.setCountry("Armenia");
        address.setZipCode("0060");
        address.setShipping(true);
        address.setUser(user);

        assertEquals("Failed to add the shippig address", true, userDao.addUserAddress(address));
    }

    /**
     * test getting user's billing address by user id
     * @asserts true or false
     */
    @Test
    public void testGetUserBillingAddress() {
        user = new User();
        user.setFirstName("Aram");
        user.setLastName("Ishkhan");
        user.setEmail("aramishkhan@gmail.com");
        user.setPhoneNumber("12345");
        user.setRole("USER");
        user.setEnabled(true);
        user.setPassword("123");

        if (user.getRole().equals("USER")) {
            cart = new Cart();
            cart.setGrandTotal(25555);
            cart.setCartLines(3);
            cart.setCartUser(user);
            user.setCart(cart);
        }

        address = new UserAddress();
        address.setAddressLine("Komitas");
        address.setCity("Yerevan");
        address.setState("Not available");
        address.setCountry("Armenia");
        address.setZipCode("0025");
        address.setBilling(true);
        address.setUser(user);

        assertEquals("Failed to add the new user", true, userDao.addNewUser(user));
        assertEquals("Failed to add the billing address", true, userDao.addUserAddress(address));

        UserAddress address1 = new UserAddress();
        address1.setAddressLine("Avan");
        address1.setCity("Yerevan");
        address1.setState("Not available");
        address1.setCountry("Armenia");
        address1.setZipCode("0060");
        address1.setShipping(true);
        address1.setUser(user);

        assertEquals("Failed to add the shippig address", true, userDao.addUserAddress(address1));
        assertEquals("Failed to add the billing address line one",
                address.getAddressLine(),
                userDao.getUserBillingAddress(user.getUserId()).getAddressLine());
    }

    /**
     * test getting user's all shipping addresses by user id
     * @asserts true or false
     */
    @Test
    public void testGetUserShipingAddresses() {
        List<UserAddress> listShippingAddresses = new ArrayList<>();
        user = new User();
        user.setFirstName("Aram");
        user.setLastName("Ishkhan");
        user.setEmail("aramishkhan@gmail.com");
        user.setPhoneNumber("12345");
        user.setRole("USER");
        user.setEnabled(true);
        user.setPassword("123");

        if (user.getRole().equals("USER")) {
            cart = new Cart();
            cart.setGrandTotal(25555);
            cart.setCartLines(3);
            cart.setCartUser(user);
            user.setCart(cart);
        }

        address = new UserAddress();
        address.setAddressLine("Komitas");
        address.setCity("Yerevan");
        address.setState("Not available");
        address.setCountry("Armenia");
        address.setZipCode("0025");
        address.setBilling(true);
        address.setUser(user);
        userDao.addNewUser(user);
        userDao.addUserAddress(address);

        address = new UserAddress();
        address.setAddressLine("Avan");
        address.setCity("Yerevan");
        address.setState("Not available");
        address.setCountry("Armenia");
        address.setZipCode("0060");
        address.setShipping(true);
        address.setUser(user);
        userDao.addUserAddress(address);
        listShippingAddresses.add(address);

        address = new UserAddress();
        address.setAddressLine("Charencavan");
        address.setCity("Dilijan");
        address.setState("Not available");
        address.setCountry("Armenia");
        address.setZipCode("0060");
        address.setShipping(true);
        address.setUser(user);
        userDao.addUserAddress(address);
        listShippingAddresses.add(address);

        address = new UserAddress();
        address.setAddressLine("Ijevan");
        address.setCity("Sisyan");
        address.setState("Not available");
        address.setCountry("Armenia");
        address.setZipCode("0060");
        address.setShipping(true);
        address.setUser(user);
        userDao.addUserAddress(address);
        listShippingAddresses.add(address);

        assertEquals("Failed to add the billing address line one",
                listShippingAddresses.size(),
                userDao.getUserShippingAddresses(user.getUserId()).size());
    }

}
