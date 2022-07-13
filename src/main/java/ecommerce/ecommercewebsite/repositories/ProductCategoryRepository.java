package ecommerce.ecommercewebsite.repositories;

import ecommerce.ecommercewebsite.model.product.category.ProductCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends AbstractRepository<ProductCategory, Long> {
}
