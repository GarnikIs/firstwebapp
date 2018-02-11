package gar.iso.core.dao;

//import gar.iso.core.dto.Cart;
import gar.iso.core.dto.User;
import gar.iso.core.dto.UserAddress;

import java.util.List;

/**
 * Created by Gor on 11/28/2017.
 */
public interface UserDao {

    /**
     * adds new user
     * @param user
     * @return true or false
     */
    boolean addNewUser(User user);

    /**
     * gets the existing user
     * @param email
     * @return user
     */
    User getUserByEmail(String email);

    /**
     * gets the existing user
     * @param phoneNumber
     * @return user
     */
    User getUserByPhoneNumber(String phoneNumber);

    /**
     * gets the existing user
     * @param userId
     * @return user
     */
    User getUserByUserId(int userId);

    /**
     * gets the existing user
     * @param email
     * @param password
     * @return user
     */
    User getUserByEmailAndPassword(String email, String password);

    /**
     * adds user's address
     * @param address
     * @return true or false
     */
    boolean addUserAddress(UserAddress address);

    /**
     * gets user's billing address
     * @param userId
     * @return userAddress
     */
    UserAddress getUserBillingAddress(int userId);

    /**
     * gets user's all shipping addresses
     * @param userId
     * @return List<UserAddress>
     */
    List<UserAddress> getUserShippingAddresses(int userId);

}
