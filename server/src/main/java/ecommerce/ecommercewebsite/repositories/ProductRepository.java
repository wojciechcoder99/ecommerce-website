package ecommerce.ecommercewebsite.repositories;

import ecommerce.ecommercewebsite.model.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends AbstractRepository<Product, Long> {
}
