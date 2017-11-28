package gar.iso.core;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gor on 11/18/2017.
 */
public class CategoryDaoImplTest {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDao categoryDao;

    private Category category;

    private static List<Category> categoryList = new ArrayList<>();

    /**
     * Initializing AnnotationConfigApplicationContext and categoryDao
     */
    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("gar.iso.core");
        context.refresh();
        categoryDao = (CategoryDao) context.getBean("categoryDao");
    }

    /**
     * Test adding category into DB
     */
    @Test
    public void testAddCategory(){
        category = new Category();
        category.setCategoryName("Television");
        category.setCategoryDescription("Some description to Television");
        category.setImageUrl("CAT_1.png");
        category.setActive(true);
        categoryList.add(category);
//        Asserts true if addCategory(category) method returns true
        assertEquals("Something whent wrong when adding a new category into database: ",
                true, categoryDao.addCategory(category));
    }

    /**
     * Test  updating category
     */
    @Test
    public void testUpdateCategory(){
//        Adding category into DB
        category = new Category();
        category.setCategoryName("Laptop");
        category.setCategoryDescription("Some description to Laptop");
        category.setImageUrl("CAT_6.png");
        category.setActive(true);
        categoryDao.addCategory(category);
        category.setCategoryName("Comminication");
        category.setCategoryDescription("New description to Comminication");
        category.setImageUrl("CAT_7.png");
        category.setActive(false);
        categoryList.add(category);
//        Asserts true if update statement returns true
        assertEquals("Something whent wrong when updating a single category: ",
                true, categoryDao.updateCategory(category));
    }

    /**
     * Test  deleting category
     */
    @Test
    public void testDeleteCategory(){
//        Adding category into DB
        category = new Category();
        category.setCategoryName("Device");
        category.setCategoryDescription("Some description to Device");
        category.setImageUrl("CAT_8.png");
        category.setActive(true);
        categoryList.add(category);
        categoryDao.addCategory(category);
//        Asserts true if delete statement returns true
        assertEquals("Something went wrong when deleting (or making is_active as 'false') a single category: ",
                true, categoryDao.deleteCategory(category));
    }

    /**
     * Test  getting category by category id
     */
    @Test
    public void testGetCategoryById(){
//        Adding category into DB
        category = new Category();
        category.setCategoryName("Internet");
        category.setCategoryDescription("Some description to Internet");
        category.setImageUrl("CAT_5.png");
        category.setActive(true);
        categoryList.add(category);
        categoryDao.addCategory(category);
//        Asserts true if returned category name is same as newly imported category name
        assertEquals("Something went wrong when  fetching new added category from database: ",
                category.getCategoryName(), categoryDao.getCategoryById(category.getCategoryId()).getCategoryName());
    }

    /**
     * Test  getting active category list
     */

    @Test
    public void testGetCategoryList(){
//        First category
        category = new Category();
        category.setCategoryName("Cabel TV");
        category.setCategoryDescription("Some description to Cabel TV");
        category.setImageUrl("CAT_2.png");
        category.setActive(true);
        categoryList.add(category);
        categoryDao.addCategory(category);
//        Second category
        category = new Category();
        category.setCategoryName("Mobile");
        category.setCategoryDescription("Some description to Mobile");
        category.setImageUrl("CAT_3.png");
        category.setActive(false);
        categoryList.add(category);
        categoryDao.addCategory(category);
//        Third category
        category = new Category();
        category.setCategoryName("Computer");
        category.setCategoryDescription("Some description to Computer");
        category.setImageUrl("CAT_4.png");
        category.setActive(true);
        categoryList.add(category);
        categoryDao.addCategory(category);

//        Asserts true if returned category size is same as newly imported category name
        assertEquals("Something went wrong when  fetching new added categories from database: ",
                categoryList.size()-3, categoryDao.getCategoryList().size());
    }

}
