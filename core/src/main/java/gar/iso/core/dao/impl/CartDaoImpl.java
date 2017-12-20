package gar.iso.core.dao.impl;

import gar.iso.core.dao.CartDao;
import gar.iso.core.dao.CartLineDao;
import gar.iso.core.dto.Cart;
import gar.iso.core.dto.CartLine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Gor on 12/3/2017.
 */
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * adds cart if somehow it was not created registration time
     * @param cart
     * @return true or false
     */
    @Override
    public boolean addUserCartByCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().persist(cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * updates cart
     * @param cart
     * @return true or false
     */
    @Override
    public boolean updateCartByCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().update(cart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * gets existing cart for user
     * @param userId
     * @return cart
     */
    @Override
    public Cart getCartByUserId(int userId) {
        String selectCartByUserId = "from Cart where cart_user_id = (:userId)";
        Cart cart = null;
        try {
            cart = sessionFactory.getCurrentSession()
                    .createQuery(selectCartByUserId, Cart.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }
}
