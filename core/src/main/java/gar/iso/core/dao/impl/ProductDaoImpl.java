package gar.iso.core.dao.impl;

import gar.iso.core.dao.ProductDao;
import gar.iso.core.dto.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Gor on 11/19/2017.
 */
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;


//    Adding new single product
    @Override
    public boolean addProduct(Product product) {
        try {
            sessionFactory.getCurrentSession().persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DatabaseException occurred while adding product: " + product.getProductName() + ",/ " + e.getMessage());
            return false;
        }
    }


//    Updating new single product
    @Override
    public boolean updateProduct(Product product) {
        try {
            sessionFactory.getCurrentSession().update(product);
            return true;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while updating single category: " + product.getProductId() + ",/ " + e.getMessage());
            return false;
        }
    }

//    Deleting new single product
    @Override
    public boolean deleteProduct(Product product) {
        product.setActive(false);
        try {
            sessionFactory.getCurrentSession().update(product);
            return true;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while deleting (or making active flag as 'false') single product: " + product.getProductId() + ",/ " + e.getMessage());
            return false;
        }
    }

//    Retrieving single product by product id
    @Override
    public Product getProductById(int productId) {
        Product product = null;
        try {
            product = sessionFactory.getCurrentSession().get(Product.class, productId);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while getting single product by id: " + productId + ",/ " + e.getMessage());
        }
        return product;
    }

//    Retrieving active product list
    @Override
    public List<Product> getActiveProductList(int langKey) {
        List<Product> products = null;
        String selectActiveProducts = "FROM Product WHERE product_is_active = 1 AND product_lang_id = " + langKey;
        try{
            Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts);
            products = query.list();
            if (products == null || products.size() <= 0) {
                throw new EntityNotFoundException("Product list is empty");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFoundException is thrown while getting the list of products from the database: " + e.getMessage());
        }
        return products;
    }
//    Retrieving all product list
    @Override
    public List<Product> getAllProductList(int langKey) {
        List<Product> products = null;
        String selectActiveProducts = "FROM Product WHERE product_lang_id = " + langKey;
        try{
            Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class);
            products = query.list();
            if (products == null || products.size() <= 0) {
                throw new EntityNotFoundException("Product list is empty");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFoundException is thrown while getting the list of products from the database: " + e.getMessage());
        }
        return products;
    }

//    Retrieving active pruduct list by category id
    @Override
    public List<Product> getActiveProductListByCategoryId(int categoryId) {
            List<Product> products = null;
        String selectActiveProductsBYCategoryId = "FROM Product WHERE product_category_id = (:categoryId) AND product_is_active = (:active)";
        try{
            Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsBYCategoryId, Product.class);
            query.setParameter("categoryId", categoryId);
            query.setParameter("active", true);
            products = query.list();
            if (products == null || products.size() <= 0) {
                throw new EntityNotFoundException("Category list is empty");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFoundException is thrown while getting the list of products from the database: " + e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getLatestActiveProductsByCount(int count) {
        List<Product> products = null;
        String selectActiveProductsBYCategoryId = "FROM Product WHERE product_is_active = (:active) ORDER BY productId DESC";
            try{
                products = sessionFactory.getCurrentSession()
                        .createQuery(selectActiveProductsBYCategoryId, Product.class)
                        .setParameter("active", true)
                        .setFirstResult(0)
                        .setMaxResults(count)
                            .getResultList();
//            products = query.getlist();
            if (products == null || products.size() <= 0) {
                throw new EntityNotFoundException("Category list is empty");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFoundException is thrown while getting the list of products from the database: " + e.getMessage());
        }
        return products;
    }
}
