package gar.iso.core.repository;

import gar.iso.core.model.CategoryType;
import gar.iso.core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByProductName (final String productName);
    Product findProductByProductCategoryType(final CategoryType productCategoryType);
}
