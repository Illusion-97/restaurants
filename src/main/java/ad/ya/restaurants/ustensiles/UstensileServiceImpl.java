package ad.ya.restaurants.ustensiles;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ToString
@RequiredArgsConstructor
public class UstensileServiceImpl implements UstensileService {
    private final UstensileRepository repository;
    private final UstensileMapper mapper;


    @Override
    public Page<UstensileDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDto);
    }

    @Override
    public UstensileDto saveOrUpdate(UstensileDto ustensileDto) {
        return toDto(repository.saveAndFlush(toEntity(ustensileDto)));
    }

    @Override
    public Optional<UstensileDto> findById(long id) {
        return repository.findById(id).map(this::toDto);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }


    private UstensileDto toDto(Ustensile ustensile) {
        return mapper.toDto(ustensile);
    }

    private Ustensile toEntity(UstensileDto ustensileDto) {
        return mapper.toEntity(ustensileDto);
    }

}
