package ecommerce.ecommercewebsite.controllers.implementation;

import ecommerce.ecommercewebsite.model.product.AbstractDTO;
import ecommerce.ecommercewebsite.model.product.ProductDTO;
import ecommerce.ecommercewebsite.services.interfaces.IAbstractService;

import java.util.List;

public class ProductController extends AbstractController<ProductDTO> {

    public ProductController(IAbstractService<ProductDTO> service) {
        super(service);
    }
}
