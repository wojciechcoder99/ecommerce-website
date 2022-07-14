package ecommerce.ecommercewebsite.services.implementation;

import ecommerce.ecommercewebsite.model.product.AbstractEntity;
import ecommerce.ecommercewebsite.model.product.Product;
import ecommerce.ecommercewebsite.model.product.ProductDTO;
import ecommerce.ecommercewebsite.repositories.AbstractRepository;
import ecommerce.ecommercewebsite.repositories.ProductRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ProductService extends AbstractService<Product, ProductDTO> {

    private ProductRepository productRepository;

    public ProductService(ModelMapper modelMapper, ProductRepository productRepository) {
        super(modelMapper);
        this.productRepository = productRepository;
    }

    @Override
    protected AbstractRepository<Product, Long> getInstance() {
        return productRepository;
    }

    @Override
    protected ProductDTO convertToDto(Product product) {
        return null;
    }

    @Override
    protected Product convertToEntity(ProductDTO productDTO) {
        return null;
    }

}
