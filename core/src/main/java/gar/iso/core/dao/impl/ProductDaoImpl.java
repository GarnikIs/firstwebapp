package gar.iso.core.dao.impl;

import gar.iso.core.dao.ProductDao;
import gar.iso.core.dto.Product;
import gar.iso.core.dto.ProductType;
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
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    //    Adding single product type
    @Override
    public boolean addProductType(ProductType productType) {
        try {
            sessionFactory.getCurrentSession().persist(productType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DatabaseException is thrown while adding a product type into database: " + productType.getProductTypeName() + ",/ " + e.getMessage());
            return false;
        }
    }

    //    Adding new single product
    @Override
    public boolean addProduct(Product product) {
        try {
            sessionFactory.getCurrentSession().persist(product);
            sessionFactory.getCurrentSession().clear();
            if (product.getProductLangId() == 2) {
                product.setProductId(0);
                product.setProductLangId(1);
                product.setProductName(product.getProductNameEn());
                sessionFactory.getCurrentSession().persist(product);
            } else {
                product.setProductId(0);
                product.setProductLangId(2);
                product.setProductName(product.getProductNameRu());
                sessionFactory.getCurrentSession().persist(product);
            }
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
        Product selectedProduct = null;
        String selectProdByTypeAndLangId = null;
        Query query = null;

        try {
            if (product.getProductLangId() == 2) {
                selectProdByTypeAndLangId = "FROM Product WHERE product_type = " + product.getProductType().getProductTypeId()
                        + " AND product_lang_id = " + 1;
                query = sessionFactory.getCurrentSession().createQuery(selectProdByTypeAndLangId);
                selectedProduct = (Product) query.list().get(0);
                product.setProductId(selectedProduct.getProductId());
                product.setProductLangId(1);
                product.setProductDescription(selectedProduct.getProductDescriptionEn());
                product.setProductName(selectedProduct.getProductNameEn());
                selectedProduct = product;
                sessionFactory.getCurrentSession().clear();
                sessionFactory.getCurrentSession().update(selectedProduct);

                selectProdByTypeAndLangId = "FROM Product WHERE product_type = " + product.getProductType().getProductTypeId()
                        + " AND product_lang_id = " + 2;
                query = sessionFactory.getCurrentSession().createQuery(selectProdByTypeAndLangId);
                selectedProduct = (Product) query.list().get(0);
                product.setProductId(selectedProduct.getProductId());
                product.setProductLangId(2);
                product.setProductDescription(selectedProduct.getProductDescriptionRu());
                product.setProductName(selectedProduct.getProductNameRu());
                selectedProduct = product;
                sessionFactory.getCurrentSession().clear();
                sessionFactory.getCurrentSession().update(selectedProduct);
            } else {
                selectProdByTypeAndLangId = "FROM Product WHERE product_type = " + product.getProductType().getProductTypeId()
                        + " AND product_lang_id = " + 2;
                query = sessionFactory.getCurrentSession().createQuery(selectProdByTypeAndLangId);
                selectedProduct = (Product) query.list().get(0);
                product.setProductId(selectedProduct.getProductId());
                product.setProductLangId(2);
                product.setProductDescription(selectedProduct.getProductDescriptionRu());
                product.setProductName(selectedProduct.getProductNameRu());
                selectedProduct = product;
                sessionFactory.getCurrentSession().clear();
                sessionFactory.getCurrentSession().update(selectedProduct);

                selectProdByTypeAndLangId = "FROM Product WHERE product_type = " + product.getProductType().getProductTypeId()
                        + " AND product_lang_id = " + 1;
                query = sessionFactory.getCurrentSession().createQuery(selectProdByTypeAndLangId);
                selectedProduct = (Product) query.list().get(0);
                product.setProductId(selectedProduct.getProductId());
                product.setProductLangId(1);
                product.setProductDescription(selectedProduct.getProductDescriptionEn());
                product.setProductName(selectedProduct.getProductNameEn());
                selectedProduct = product;
                sessionFactory.getCurrentSession().clear();
                sessionFactory.getCurrentSession().update(selectedProduct);
            }

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

    //    Retrieving single product by product id and lang id
    @Override
    public Product getProductById(int productId, int langKey) {
        Product product = null;
        String selectProdByTypeAndLangId = "FROM Product WHERE product_type = " + productId
                + " AND product_lang_id = " + langKey;
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(selectProdByTypeAndLangId);
            if (query != null) {
                product = (Product) query.getResultList().get(0);
            } else {
                throw new EntityNotFoundException();
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while getting single product " +
                    "by type and lang id: " + productId + ",/ " + langKey + ",/ " + e.getMessage());
        }
        return product;
    }

    //    Retrieving active product list
    @Override
    public List<Product> getActiveProductList(int langKey) {
        List<Product> products = null;
        String selectActiveProducts = "FROM Product WHERE product_is_active = 1 AND product_lang_id = " + langKey;
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts);
            products = query.list();
            if (products == null || products.size() <= 0) {
                throw new EntityNotFoundException("Product list is empty");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFoundException is thrown while getting t" +
                    "he list of products from the database: " + e.getMessage());
        }
        return products;
    }

    //    Retrieving all product list
    @Override
    public List<Product> getAllProductList(int langKey) {
        List<Product> products = null;
        String selectActiveProducts = "FROM Product WHERE product_lang_id = " + langKey;
        try {
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
    public List<Product> getActiveProductListByCategoryId(int categoryTypeId, int langKey) {
        List<Product> products = null;
        String selectActiveProductsBYCategoryId = "FROM Product WHERE product_category_type_id = (:categoryId) " +
                                                  "AND product_is_active = (:active) " +
                                                  "AND product_lang_id = (:langKey)";
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsBYCategoryId, Product.class);
            query.setParameter("categoryId", categoryTypeId);
            query.setParameter("active", true);
            query.setParameter("langKey", langKey);
            products = query.list();
            if (products == null || products.size() <= 0) {
                throw new EntityNotFoundException("Product list by category id is empty");
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
        try {
            products = sessionFactory.getCurrentSession()
                    .createQuery(selectActiveProductsBYCategoryId, Product.class)
                    .setParameter("active", true)
                    .setFirstResult(0)
                    .setMaxResults(count)
                    .getResultList();
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
