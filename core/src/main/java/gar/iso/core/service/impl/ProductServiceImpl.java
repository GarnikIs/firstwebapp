package gar.iso.core.service.impl;

import gar.iso.core.dto.ProductDTO;
import gar.iso.core.repository.ProductRepository;
import gar.iso.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO findById(final Long id) {
        return null;
    }

    @Override
    public ProductDTO create(ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO findByProductName(String productName) {
        return null;
    }

    @Override
    public ProductDTO findByUserId(Long userID) {
        return null;
    }

    @Override
    public ProductDTO findByProductDescription(String productDescription) {
        return null;
    }

    @Override
    public ProductDTO findByProductCategory(String productCategory) {
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        return null;
    }
}
