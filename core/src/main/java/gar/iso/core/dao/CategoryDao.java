package gar.iso.core.dao;

import gar.iso.core.dto.Category;

import java.util.List;

/**
 * Created by Gor on 11/17/2017.
 */
public interface CategoryDao {

//    CRUD methods of category dao layer
    boolean addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(Category category);

    List<Category> getCategoryList();

    Category getCategoryById(int categoryId);

}
