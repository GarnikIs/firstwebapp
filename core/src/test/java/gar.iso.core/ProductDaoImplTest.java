package gar.iso.core;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dao.ProductDao;
import gar.iso.core.dao.UserDao;
import gar.iso.core.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gor on 11/18/2017.
 */
public class ProductDaoImplTest {

    private static AnnotationConfigApplicationContext context;

    private static ProductDao productDao;

    private static CategoryDao categoryDao;

    private static UserDao userDao;

    private Product product;

    private static List<Product> productList = new ArrayList<>();

    /**
     * Initializing AnnotationConfigApplicationContext and productDao
     */
    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("gar.iso.core");
        context.refresh();
        productDao = (ProductDao) context.getBean("productDao");
        categoryDao = (CategoryDao) context.getBean("categoryDao");
        categoryDao = (CategoryDao) context.getBean("categoryDao");
        userDao = (UserDao) context.getBean("userDao");
    }

    /**
     * Test adding product into DB
     */
    @Test
    public void testAddProduct(){
        product = new Product();
        product.setCode("ASD");
        product.setProductName("Iphone 5s");
        product.setBrand("Apple");
        product.setProductDescription("Some description to Iphone 5s");
        product.setUnitPrice(200000);
        product.setQuantity(3);
        product.setActive(true);
//        product.setProductCategoryId(1);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(1);
        product.setViews(1);
        productList.add(product);
//        Asserts true if addProduct(product) method returns true
        assertEquals("Something went wrong when adding a new single product into database: ",
                true, productDao.addProduct(product));
    }

    /**
     * Test  updating product
     */
    @Test
    public void testUpdateProduct(){
//        Adding product into DB
        product = new Product();
        product.setCode("ASD");
        product.setProductName("Iphone 5s");
        product.setBrand("Apple");
        product.setProductDescription("Some description to Iphone 5s");
        product.setUnitPrice(200000);
        product.setQuantity(3);
        product.setActive(true);
//        product.setProductCategoryId(1);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(1);
        product.setViews(1);
        productList.add(product);
        productDao.addProduct(product);
        product.setActive(false);
//        Asserts true if update statement returns true
        assertEquals("Something went wrong when updating a single product: ",
                true, productDao.updateProduct(product));
    }

    /**
     * Test  deleting product
     */
    @Test
    public void testDeleteProduct(){
//        Adding product into DB
        product = new Product();
        product.setCode("ASD");
        product.setProductName("Iphone 5s");
        product.setBrand("Apple");
        product.setProductDescription("Some description to Iphone 5s");
        product.setUnitPrice(200000);
        product.setQuantity(3);
        product.setActive(true);
//        product.setProductCategoryId(1);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(1);
        product.setViews(1);
        productList.add(product);
        productDao.addProduct(product);
        product.setActive(false);
//        Asserts true if delete statement returns true
        assertEquals("Something went wrong when deleting (or making is_active as 'flase') a single product: ",
                true, productDao.deleteProduct(product));
    }

    /**
     * Test  getting product by product id
     */
    @Test
    public void testGetProductById(){
//        Adding product into DB
        product = new Product();
        product.setCode("ASD");
        product.setProductName("Iphone 5s");
        product.setBrand("Apple");
        product.setProductDescription("Some description to Iphone 5s");
        product.setUnitPrice(200000);
        product.setQuantity(3);
        product.setActive(true);
//        product.setProductCategoryId(1);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(1);
        product.setViews(1);
        productList.add(product);
        productDao.addProduct(product);
//        Asserts true if returned product name is same as newly imported product name
        assertEquals("Something went wrong when fetching a new added single product from database: ",
                product.getProductName(), productDao.getProductById(product.getProductId()).getProductName());
    }

    /**
     * Test  getting all product list for admin
     */

    @Test
    public void testGetAllProductListForAdmin(){

//        Asserts true if returned all product list size is same as
//        currently actual all products which was 18 at that time
        assertEquals("Something went wrong when fetching a all product list from database: ",
                18,
                productDao.getAllProductList().size());
    }

    /**
     * Test  getting active product list
     */

    @Test
    public void testGetActiveProductList(){
//        First product
        product = new Product();
        product.setCode("ASD");
        product.setProductName("Iphone 5s");
        product.setBrand("Apple");
        product.setProductDescription("Some description to Iphone 5s");
        product.setUnitPrice(200000);
        product.setQuantity(3);
        product.setActive(true);
//        product.setProductCategoryId(1);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(1);
        product.setViews(1);
        productList.add(product);
        productDao.addProduct(product);
//        Second product
        product = new Product();
        product.setCode("QWE");
        product.setProductName("SamsungTV");
        product.setBrand("SAMSUG");
        product.setProductDescription("Some description to SamsungTV");
        product.setUnitPrice(400000);
        product.setQuantity(5);
        product.setActive(false);
//        product.setProductCategoryId(2);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(5);
        product.setViews(6);
        productList.add(product);
        productDao.addProduct(product);
//        Third product
        product = new Product();
        product.setCode("ZXC");
        product.setProductName("Toshiba C45");
        product.setBrand("TOSHIBA");
        product.setProductDescription("Some description to Toshiba C45");
        product.setUnitPrice(600000);
        product.setQuantity(2);
        product.setActive(true);
//        product.setProductCategoryId(3);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(10);
        product.setViews(78);
        productList.add(product);
        productDao.addProduct(product);

//        Asserts true if returned product size is same as newly imported product name
        assertEquals("Something went wrong when fetching a new added active product list from database: ",
                productList.size()-2,
                productDao.getActiveProductList().size());
    }

    /**
     * Test  getting active product list of one category by category id
     */
    @Test
    public void testGetActiveProductListByCategory(){
//        First product
        product = new Product();
        product.setCode("ASD");
        product.setProductName("Iphone 5s");
        product.setBrand("Apple");
        product.setProductDescription("Some description to Iphone 5s");
        product.setUnitPrice(200000);
        product.setQuantity(3);
        product.setActive(true);
//        product.setProductCategoryId(1);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(1);
        product.setViews(1);
        productList.add(product);
        productDao.addProduct(product);
//        Second product
        product = new Product();
        product.setCode("QWE");
        product.setProductName("SamsungTV");
        product.setBrand("SAMSUG");
        product.setProductDescription("Some description to SamsungTV");
        product.setUnitPrice(400000);
        product.setQuantity(11);
        product.setActive(false);
//        product.setProductCategoryId(2);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(5);
        product.setViews(6);
        productList.add(product);
        productDao.addProduct(product);
//        Third product
        product = new Product();
        product.setCode("ZXC");
        product.setProductName("Toshiba C45");
        product.setBrand("TOSHIBA");
        product.setProductDescription("Some description to Toshiba C45");
        product.setUnitPrice(600000);
        product.setQuantity(2);
        product.setActive(true);
//        product.setProductCategoryId(3);
        product.setProductCategory(categoryDao.getCategoryList().get(1));
        product.setProductUser(userDao.getUserByUserId(3));
        product.setPurchases(10);
        product.setViews(78);
        productList.add(product);
        productDao.addProduct(product);

//        Asserts true if returned product size is same as newly imported product name
        assertEquals("Something went wrong when fetching a new added active product list by category id from database: ",
                productList.size()-1,
//                productDao.getActiveProductListByCategoryId(product.getProductCategoryId()).size());
                productDao.getActiveProductListByCategoryId(product.getProductCategory().getCategoryId()).size());
    }

    /**
     * Test  getting active product list of one category by category id
     */
    @Test
    public void testGetLatestActiveProductsByCount(){
//        Asserts true if returned product size is same as newly imported product name
        assertEquals("Something went wrong when fetching latest active product list by count: ",
                5,
                productDao.getLatestActiveProductsByCount(5).size());
    }

}
