package ecommerce.ecommercewebsite.controllers.implementation;

import ecommerce.ecommercewebsite.annotations.AllowExceptionHandler;
import ecommerce.ecommercewebsite.exceptions.ProvidedElementIsNullException;
import ecommerce.ecommercewebsite.model.product.ProductDTO;
import ecommerce.ecommercewebsite.services.interfaces.IAbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllowExceptionHandler
public class ProductController extends AbstractController<ProductDTO> {

    public ProductController(IAbstractService<ProductDTO> service) {
        super(service);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ProductDTO> findOne(@PathVariable Long id) {
        return super.findOne(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductDTO>> findAll() {
        return super.findAll();
    }

    @PostMapping
    @Override
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) throws ProvidedElementIsNullException {
        return super.create(product);
    }

    @PostMapping("/{id}")
    @Override
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO product) {
        return super.update(id, product);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}