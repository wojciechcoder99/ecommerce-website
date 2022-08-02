package ecommerce.ecommercewebsite.controllers.implementation;

import ecommerce.ecommercewebsite.annotations.AllowExceptionHandler;
import ecommerce.ecommercewebsite.controllers.interfaces.IAbstractController;
import ecommerce.ecommercewebsite.exceptions.ProvidedElementIsNullException;
import ecommerce.ecommercewebsite.model.product.AbstractDTO;
import ecommerce.ecommercewebsite.services.interfaces.IAbstractService;

import java.util.List;
import java.util.Optional;

public abstract class AbstractController implements IAbstractController {
    protected final IAbstractService<AbstractDTO> service;

    public AbstractController(IAbstractService<AbstractDTO> service) {
        this.service = service;
    }

    @AllowExceptionHandler
    @Override
    public Optional<AbstractDTO> create(AbstractDTO product) throws ProvidedElementIsNullException {
        return Optional.ofNullable(product).map(service::create)
                .orElseThrow(ProvidedElementIsNullException::new);
    }

    @Override
    public Optional<AbstractDTO> update(Long id, AbstractDTO product) {
        return service.findById(id).map(p -> service.update(product, id)).orElseThrow();
    }

    @Override
    public AbstractDTO findOne(Long id) {
        return service.findById(id).orElseThrow();
    }

    @Override
    public List<AbstractDTO> findAll() {
        return service.findAll();
    }

    @Override
    public boolean delete(Long id) {
        return service.findById(id).map(p -> service.delete(id)).orElseThrow();
    }
}
