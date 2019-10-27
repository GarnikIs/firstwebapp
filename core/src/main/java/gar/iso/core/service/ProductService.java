package gar.iso.core.service;

import gar.iso.core.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO findById(final Long id);

    ProductDTO create(final ProductDTO product);

    ProductDTO findByProductName(final String productName);

    ProductDTO findByUserId(final Long userID);

    ProductDTO findByProductDescription(final String productDescription);

    ProductDTO findByProductCategory(final String productCategory);

    List<ProductDTO> findAll();
}
