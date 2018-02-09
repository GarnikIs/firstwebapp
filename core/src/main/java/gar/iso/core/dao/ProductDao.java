package gar.iso.core.dao;

import gar.iso.core.dto.Product;
import gar.iso.core.dto.ProductType;

import java.util.List;

/**
 * Created by Gor on 11/19/2017.
 */
public interface ProductDao {

//    CRUD methods of product dao layer
    boolean addProductType(ProductType productType);
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(Product product);
    Product getProductById(int productId, int langKey);
    List<Product> getActiveProductList(int langKey);
    List<Product> getAllProductList(int langKey);

//    business methods of product dao layer
    List<Product> getActiveProductListByCategoryId(int categoryTypeId, int langKey);
    List<Product> getLatestActiveProductsByCount(int count);

}
