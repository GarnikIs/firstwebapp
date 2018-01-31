//package gar.iso.core;
//
//import gar.iso.core.dao.CategoryDao;
//import gar.iso.core.dto.Category;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import static org.junit.Assert.assertEquals;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Gor on 11/18/2017.
// */
//public class CategoryDaoImplTest {
//
//    private static AnnotationConfigApplicationContext context;
//
//    private static CategoryDao categoryDao;
//
//    private Category category;
//
//    private static List<Category> categoryList = new ArrayList<>();
//
//    /**
//     * Initializing AnnotationConfigApplicationContext and categoryDao
//     */
//    @BeforeClass
//    public static void init() {
//        context = new AnnotationConfigApplicationContext();
//        context.scan("gar.iso.core");
//        context.refresh();
//        categoryDao = (CategoryDao) context.getBean("categoryDao");
//    }
//
//    /**
//     * Test adding category into DB
//     */
//    @Test
//    public void testAddCategory(){
//        category = new Category();
//        category.setCategoryName("Television");
//        categoryList.add(category);
////        Asserts true if addCategory(category) method returns true
//        assertEquals("Something whent wrong when adding a new category into database: ",
//                true, categoryDao.addCategory(category));
//    }
//
//    /**
//     * Test  getting category by category id
//     */
//    @Test
//    public void testGetCategoryById(){
////        Adding category into DB
//        category = new Category();
//        category.setCategoryName("Internet");
//        categoryList.add(category);
//        categoryDao.addCategory(category);
////        Asserts true if returned category name is same as newly imported category name
//        assertEquals("Something went wrong when  fetching new added category from database: ",
//                category.getCategoryName(), categoryDao.getCategoryById(category.getCategoryId()).getCategoryName());
//    }
//
//    /**
//     * Test  getting active category list
//     */
//
//    @Test
//    public void testGetCategoryList(){
////        First category
//        category = new Category();
//        category.setCategoryName("Cabel TV");
//        categoryList.add(category);
//        categoryDao.addCategory(category);
////        Second category
//        category = new Category();
//        category.setCategoryName("Mobile");
//        categoryList.add(category);
//        categoryDao.addCategory(category);
////        Third category
//        category = new Category();
//        category.setCategoryName("Computer");
//        categoryList.add(category);
//        categoryDao.addCategory(category);
//
////        Asserts true if returned category size is same as newly imported category name
//        assertEquals("Something went wrong when  fetching new added categories from database: ",
//                categoryList.size()-3, categoryDao.getCategoryList(1).size());
//    }
//
//}
