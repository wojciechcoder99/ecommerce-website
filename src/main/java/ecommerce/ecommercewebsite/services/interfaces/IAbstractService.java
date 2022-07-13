package ecommerce.ecommercewebsite.services.interfaces;

import ecommerce.ecommercewebsite.model.product.AbstractDTO;

import java.util.List;
import java.util.Optional;

public interface IAbstractService {
    Optional<AbstractDTO> create(AbstractDTO dto);
    Optional<AbstractDTO> update(AbstractDTO dto);
    Optional<AbstractDTO> getOne(Long id);
    List<AbstractDTO> getAll();
    void delete(Long id);

}
