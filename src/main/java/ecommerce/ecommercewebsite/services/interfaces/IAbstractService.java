package ecommerce.ecommercewebsite.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface IAbstractService<AbstractDTO> {
    Optional<AbstractDTO> create(AbstractDTO dto);
    Optional<AbstractDTO> update(AbstractDTO dto, Long id);
    Optional<AbstractDTO> findById(Long id);
    List<AbstractDTO> findAll();
    boolean delete(Long id);

}
