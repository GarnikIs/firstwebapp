package gar.iso.core.service.impl;

import gar.iso.core.model.Product;
import gar.iso.core.repository.ProductRepository;
import gar.iso.core.service.CategoryService;
import gar.iso.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }
}
