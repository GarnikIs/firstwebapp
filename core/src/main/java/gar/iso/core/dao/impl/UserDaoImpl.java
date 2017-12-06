package gar.iso.core.dao.impl;

import gar.iso.core.dao.UserDao;
import gar.iso.core.dto.Cart;
import gar.iso.core.dto.User;
import gar.iso.core.dto.UserAddress;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gor on 11/28/2017.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * adds new user
     * @param user
     * @return true or false
     */
    @Override
    public boolean addNewUser(User user) {
        try {
            sessionFactory.getCurrentSession().persist(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * gets the existing user
     * @param email
     * @return user
     */
    @Override
    public User getUserByEmail(String email) {
        String selectedUserByEmail = "from User where email = :email";
        User user = null;
        try {
            user = sessionFactory.getCurrentSession()
                    .createQuery(selectedUserByEmail, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    /**
     * gets the existing user
     * @param userId
     * @return user
     */
    @Override
    public User getUserByUserId(int userId) {
        String selectedUserByEmail = "from User where user_id = " + userId;
        User user = null;
        try {
            user = sessionFactory.getCurrentSession()
                    .createQuery(selectedUserByEmail, User.class)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * gets the existing user
     * @param email
     * @param password
     * @return user
     */
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String selectUserByEmail = "from User where email = :email and password = :password";
        User user = null;
        try {
            user = sessionFactory.getCurrentSession()
                    .createQuery(selectUserByEmail, User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * adds user's address
     * @param address
     * @return true or false
     */
    @Override
    public boolean addUserAddress(UserAddress address) {
        try {
            sessionFactory.getCurrentSession().persist(address);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * gets user's billing address
     * @param userId
     * @return userAddress
     */
    @Override
    public UserAddress getUserBillingAddress(int userId) {
        String addressQuery = "from UserAddress where address_user_id = :userId and billing = :billing";
        UserAddress userBillingAddress = null;
        try {
            userBillingAddress = sessionFactory.getCurrentSession()
                    .createQuery(addressQuery, UserAddress.class)
                    .setParameter("userId", userId)
                    .setParameter("billing", true)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBillingAddress;
    }

    /**
     * gets user's all shipping addresses
     * @param userId
     * @return List<UserAddress>
     */
    @Override
    public List<UserAddress> getUserShippingAddresses(int userId) {
        String addressQuery = "from UserAddress where address_user_id = :userId and shipping = :shipping";
        List<UserAddress> userShippingAddresses = null;
        try {
            userShippingAddresses = sessionFactory.getCurrentSession()
                    .createQuery(addressQuery, UserAddress.class)
                    .setParameter("userId", userId)
                    .setParameter("shipping", true)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userShippingAddresses;
    }

}
