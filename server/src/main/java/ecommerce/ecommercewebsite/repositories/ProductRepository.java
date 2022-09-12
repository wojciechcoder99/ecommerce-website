package ecommerce.ecommercewebsite.repositories;

import ecommerce.ecommercewebsite.model.product.Product;
import org.springframework.stereotype.Repository;

@Repository
//Another way to handle cross origin problems -> @CrossOrigin("url address")
public interface ProductRepository extends AbstractRepository<Product, Long> {
}
