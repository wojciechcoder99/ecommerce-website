package ecommerce.ecommercewebsite.services.implementation;

import ecommerce.ecommercewebsite.repositories.AbstractRepository;
import ecommerce.ecommercewebsite.services.interfaces.IAbstractService;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
public abstract class AbstractService<AbstractEntity, AbstractDTO> implements IAbstractService<AbstractDTO> {

    private final ModelMapper modelMapper;

    public AbstractService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected abstract AbstractRepository<AbstractEntity, Long> getInstance();
    protected abstract AbstractDTO convertToDto(AbstractEntity entity);
    protected abstract AbstractEntity convertToEntity(AbstractDTO dto);

    @Override
    public Optional<AbstractDTO> create(AbstractDTO dto) {
        return Optional.ofNullable(convertToDto(getInstance().save(convertToEntity(dto))));
    }

    @Override
    public Optional<AbstractDTO> update(AbstractDTO dto, Long id) {
        if(getInstance().existsById(id) && dto != null) {
            return Optional.of(convertToDto(getInstance().save(convertToEntity(dto))));
        }
        return Optional.empty();
    }

    @Override
    public Optional<AbstractDTO> findById(Long id) {
        return getInstance().existsById(id) ? getInstance().findById(id).map(this::convertToDto)
                : Optional.empty();
    }

    @Override
    public List<AbstractDTO> findAll() {
        return getInstance().findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        if (getInstance().existsById(id)) {
            getInstance().deleteById(id);
            return true;
        }
        return false;
    }
}
