package gar.iso.core.dao;

import gar.iso.core.dto.Category;
import gar.iso.core.dto.CategoryType;

import java.util.List;

/**
 * Created by Gor on 11/17/2017.
 */
public interface CategoryDao {

//    CRUD methods of category dao layer
    boolean addCategoryType(CategoryType categoryType);

    boolean addCategory(Category category);

    List<Category> getCategoryList(int langKey);

    Category getCategoryById(int categoryId, int langKey);

}
