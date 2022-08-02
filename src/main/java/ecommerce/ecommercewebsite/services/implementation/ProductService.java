package ecommerce.ecommercewebsite.services.implementation;

import ecommerce.ecommercewebsite.model.product.Product;
import ecommerce.ecommercewebsite.model.product.ProductDTO;
import ecommerce.ecommercewebsite.repositories.AbstractRepository;
import ecommerce.ecommercewebsite.repositories.ProductRepository;
import org.modelmapper.ModelMapper;

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
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    protected Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

}
