package gar.iso.core.service;

import gar.iso.core.model.Product;

public interface ProductService {
    Product findById(final Integer id);
}
