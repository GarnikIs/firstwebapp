package gar.iso.core.dao.impl;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.dto.Category;
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

//    Adding single category
    @Override
    public boolean addCategory(Category category) {
        try {
            sessionFactory.getCurrentSession().persist(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DatabaseException is thrown while adding a category into database: " + category.getName() + ",/ " + e.getMessage());
            return false;
        }
    }

//    Updating single category by category
    @Override
    public boolean updateCategory(Category category) {
        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        } catch(EntityNotFoundException  e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while updating single category: " + category.getCategoryId() + ",/ " + e.getMessage());
            return false;
        }
    }

//    Deleting single category by category id
    @Override
    public boolean deleteCategory(Category category) {
        category.setActive(false);
        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        } catch(EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while deleting (or making active flag as 'false') category by id: " + category.getCategoryId() + ",/ " + e.getMessage());
            return false;
        }
    }

//    Retrieving single category by category id
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

//    Retrieving active category list
    @Override
    public List<Category> getCategoryList() {
        List<Category> categories = null;
        String selectActiveCategories = "FROM Category WHERE category_is_active = 1";
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
