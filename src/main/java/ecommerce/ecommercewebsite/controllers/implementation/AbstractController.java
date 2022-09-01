package ecommerce.ecommercewebsite.controllers.implementation;

import ecommerce.ecommercewebsite.annotations.AllowExceptionHandler;
import ecommerce.ecommercewebsite.controllers.interfaces.IAbstractController;
import ecommerce.ecommercewebsite.exceptions.ProvidedElementIsNullException;
import ecommerce.ecommercewebsite.services.interfaces.IAbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class AbstractController<AbstractDTO> implements IAbstractController<AbstractDTO> {
    protected final IAbstractService<AbstractDTO> service;

    public AbstractController(IAbstractService<AbstractDTO> service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<AbstractDTO> create(AbstractDTO product) throws ProvidedElementIsNullException {
        return Optional.ofNullable(product).map(service::create)
                .map(Optional::get)
                .map(ResponseEntity::ok)
                .orElseThrow(ProvidedElementIsNullException::new);
    }

    @Override
    public ResponseEntity<AbstractDTO> update(Long id, AbstractDTO product) {
        return service.findById(id).map(p -> service.update(product, id))
                .map(Optional::get)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

    @Override
    public ResponseEntity<AbstractDTO> findOne(Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseThrow();
    }

    @Override
    public ResponseEntity<List<AbstractDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return service.findById(id).map(p -> service.delete(id))
                .map(Object::toString)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }
}
