package gar.iso.core.dao.impl;

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
@Repository("cartLineDao")
@Transactional
public class CartLineDaoImpl implements CartLineDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * adds cartLine
     * @param cartLine
     * @return true or false
     */
    @Override
    public boolean addCartLine(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().persist(cartLine);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * updates cartLine
     * @param cartLine
     * @return true or false
     */
    @Override
    public boolean updateCartLine(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().update(cartLine);
            return true;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while updating single cartline: " + cartLine.getCartLineId() + ",/ " + e.getMessage());
            return false;
        }
    }

    /**
     * deletes cartLine
     * @param cartLine
     * @return true or false
     */
    @Override
    public boolean deleteCartLine(CartLine cartLine) {
        try {
            sessionFactory.getCurrentSession().delete(cartLine);
            return true;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while deleting single cartline: " + cartLine.getCartLineId() + ",/ " + e.getMessage());
            return false;
        }
    }

    /**
     * gets cartLine by cartline id
     * @param cartLineId
     * @return true or false
     */
    @Override
    public CartLine getCartLine(int cartLineId) {
        return sessionFactory.getCurrentSession().get(CartLine.class, cartLineId);
    }

    /**
     * gets list of cartLines
     * @param cartId
     * @return true or false
     */
    @Override
    public List<CartLine> getListOfCartLines(int cartId) {
        String query = "from CartLine where cartline_cart_id = :cartId";
        return sessionFactory.getCurrentSession()
                .createQuery(query, CartLine.class)
                .setParameter("cartId", cartId).getResultList();
    }

    /**
     * gets list of available cartlines
     * @param cartId
     * @return true or false
     */
    @Override
    public List<CartLine> getListOfAvailableCartLines(int cartId) {
        String query = "from CartLine where cartline_cart_id = :cartId and is_available = :available";
        return sessionFactory.getCurrentSession()
                .createQuery(query, CartLine.class)
                .setParameter("cartId", cartId)
                .setParameter("available", true)
                .getResultList();
    }

    /**
     * gets single cartline
     * @param cartId
     * @param productId
     * @return true or false
     */
    @Override
    public CartLine getByCartIdAndProductId(int cartId, int productId) {
        String query = "from CartLine where cartline_cart_id = :cartId and " +
                "cartline_product_id = :productId";
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(query, CartLine.class)
                    .setParameter("cartId", cartId)
                    .setParameter("productId", productId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
