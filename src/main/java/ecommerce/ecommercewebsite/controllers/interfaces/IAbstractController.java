package ecommerce.ecommercewebsite.controllers.interfaces;

import ecommerce.ecommercewebsite.exceptions.ProvidedElementIsNullException;
import ecommerce.ecommercewebsite.model.product.AbstractDTO;
import ecommerce.ecommercewebsite.model.product.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IAbstractController {
    Optional<AbstractDTO> create(AbstractDTO product) throws ProvidedElementIsNullException;
    Optional<AbstractDTO> update(Long id, AbstractDTO product);
    AbstractDTO findOne(Long id);
    List<AbstractDTO> findAll();
    boolean delete(Long id);
}
