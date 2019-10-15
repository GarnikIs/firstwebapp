package gar.iso.core.service.impl;

import gar.iso.core.model.Category;
import gar.iso.core.repository.CategoryRepository;
import gar.iso.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }
}
