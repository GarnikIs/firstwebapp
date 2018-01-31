package gar.iso.core.dao.impl;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dto.Category;
import gar.iso.core.dto.CategoryType;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Gor on 11/17/2017.
 */

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    //    Adding single category type
    @Override
    public boolean addCategoryType(CategoryType categoryType) {
        try {
            sessionFactory.getCurrentSession().persist(categoryType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DatabaseException is thrown while adding a category into database: " + categoryType.getCategoryTypeName() + ",/ " + e.getMessage());
            return false;
        }
    }

//    Adding multilingual single category
    @Override
    public boolean addCategory(Category category) {
        try {
            sessionFactory.getCurrentSession().persist(category);
            sessionFactory.getCurrentSession().clear();
            if (category.getCategoryLangId() == 2) {
                category.setCategoryId(0);
                category.setCategoryLangId(1);
                category.setCategoryName(category.getCategoryNameEn());
                sessionFactory.getCurrentSession().persist(category);
            } else {
                category.setCategoryId(0);
                category.setCategoryLangId(2);
                category.setCategoryName(category.getCategoryNameRu());
                sessionFactory.getCurrentSession().persist(category);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DatabaseException is thrown while adding a category into database: " +
                    category.getCategoryType().getCategoryTypeId() + ",/ " + e.getMessage());
            return false;
        }
    }

    //    Retrieving single category by category id and language
    @Override
    public Category getCategoryById(int categoryId) {
        Category category = null;
        try {
            category = sessionFactory.getCurrentSession().get(Category.class, categoryId);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while getting single category by id: " + categoryId + ",/ " + e.getMessage());
        }
        return category;
    }

    //    Retrieving category list
    @Override
    public List<Category> getCategoryList(int langKey) {
        List<Category> categories = null;
        String selectActiveCategories = "FROM Category WHERE category_lang_id = " + langKey;
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategories);
            categories = query.list();
            if (categories == null || categories.size() <= 0) {
                throw new EntityNotFoundException("Category list is empty");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFoundException is thrown while getting the list of categories from the database: " + e.getMessage());
        }
        return categories;
    }

}
