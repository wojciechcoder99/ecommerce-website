package ecommerce.ecommercewebsite.services.implementation;

import ecommerce.ecommercewebsite.model.product.AbstractDTO;
import ecommerce.ecommercewebsite.model.product.AbstractEntity;
import ecommerce.ecommercewebsite.repositories.AbstractRepository;
import ecommerce.ecommercewebsite.services.interfaces.IAbstractService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService implements IAbstractService {

    private final ModelMapper modelMapper;

    public AbstractService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public abstract AbstractRepository<AbstractEntity, Long> getInstance();

    @Override
    // TODO think whether it will be no problems when save method returns null
    public Optional<AbstractDTO> create(AbstractDTO dto) {
        return Optional.ofNullable(convertToDto(getInstance().save(convertToEntity(dto))));
    }

    @Override
    public Optional<AbstractDTO> update(AbstractDTO dto) {
        return null;
    }

    @Override
    public Optional<AbstractDTO> getOne(Long id) {
        return null;
    }

    @Override
    public List<AbstractDTO> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private AbstractEntity convertToEntity(AbstractDTO dto) {
        return modelMapper.map(dto, AbstractEntity.class);
    }

    private AbstractDTO convertToDto(AbstractEntity entity) {
        return modelMapper.map(entity, AbstractDTO.class);
    }
}
