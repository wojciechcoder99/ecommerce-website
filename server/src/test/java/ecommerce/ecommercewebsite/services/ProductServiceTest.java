package ecommerce.ecommercewebsite.services;

import ecommerce.ecommercewebsite.model.product.Product;
import ecommerce.ecommercewebsite.model.product.ProductDTO;
import ecommerce.ecommercewebsite.repositories.AbstractRepository;
import ecommerce.ecommercewebsite.services.implementation.AbstractService;
import org.junit.jupiter.api.BeforeEach;

public class ProductServiceTest {
    private AbstractService<Product, ProductDTO> productService;
    private AbstractRepository<Product, Long> productRepository;

    @BeforeEach()
    private void setup() {

    }
}
