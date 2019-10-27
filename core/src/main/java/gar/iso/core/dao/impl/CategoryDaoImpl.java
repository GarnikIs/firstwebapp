package gar.iso.core.dao.impl;

import gar.iso.core.dao.CategoryDao;
import gar.iso.core.model.Category;
import gar.iso.core.model.CategoryType;
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
            System.out.println("DatabaseException is thrown while adding a category type into database: " + categoryType.getCategoryTypeName() + ",/ " + e.getMessage());
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
                category.setId(0L);
                category.setCategoryLangId(1);
                category.setCategoryName(category.getCategoryNameEn());
                sessionFactory.getCurrentSession().persist(category);
            } else {
                category.setId(0L);
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
    public Category getCategoryById(int categoryTypeId, int langKey) {
        Category category = null;
        String selectCatByTypeAndLangId = "FROM Category WHERE category_type = " + categoryTypeId
                + " AND category_lang_id = " + langKey;
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(selectCatByTypeAndLangId);
            if (query != null) {
                category = (Category) query.getResultList().get(0);
            } else {
                throw new EntityNotFoundException();
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            System.out.println("EntityNotFound exception is thrown while getting single category by id: " + categoryTypeId + ",/ " + e.getMessage());
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
