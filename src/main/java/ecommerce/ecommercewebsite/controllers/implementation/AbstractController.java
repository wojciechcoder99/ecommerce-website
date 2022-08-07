package ecommerce.ecommercewebsite.controllers.implementation;

import ecommerce.ecommercewebsite.annotations.AllowExceptionHandler;
import ecommerce.ecommercewebsite.controllers.interfaces.IAbstractController;
import ecommerce.ecommercewebsite.exceptions.ProvidedElementIsNullException;
import ecommerce.ecommercewebsite.model.product.AbstractDTO;
import ecommerce.ecommercewebsite.services.interfaces.IAbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllowExceptionHandler
@RestController
@RequestMapping("api/products")
public abstract class AbstractController<AbstractDTO> implements IAbstractController<AbstractDTO> {
    protected final IAbstractService<AbstractDTO> service;

    public AbstractController(IAbstractService<AbstractDTO> service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public ResponseEntity<AbstractDTO> create(@RequestBody AbstractDTO product) throws ProvidedElementIsNullException {
        return Optional.ofNullable(product).map(service::create)
                .map(Optional::get)
                .map(ResponseEntity::ok)
                .orElseThrow(ProvidedElementIsNullException::new);
    }

    @PostMapping("/{id}")
    @Override
    public ResponseEntity<AbstractDTO> update(@PathVariable Long id, @RequestBody AbstractDTO product) {
        return service.findById(id).map(p -> service.update(product, id))
                .map(Optional::get)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AbstractDTO> findOne(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseThrow();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<AbstractDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return service.findById(id).map(p -> service.delete(id))
                .map(Object::toString)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }
}
