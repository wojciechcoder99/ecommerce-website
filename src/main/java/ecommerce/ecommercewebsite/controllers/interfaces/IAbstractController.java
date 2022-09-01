package ecommerce.ecommercewebsite.controllers.interfaces;

import ecommerce.ecommercewebsite.exceptions.ProvidedElementIsNullException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAbstractController<AbstractDTO> {
    ResponseEntity<AbstractDTO> create(AbstractDTO product) throws ProvidedElementIsNullException;
    ResponseEntity<AbstractDTO> update(Long id, AbstractDTO product);
    ResponseEntity<AbstractDTO> findOne(Long id);
    ResponseEntity<List<AbstractDTO>> findAll();
    ResponseEntity<String> delete(Long id);
}
