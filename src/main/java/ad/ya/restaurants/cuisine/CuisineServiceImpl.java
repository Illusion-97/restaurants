package ad.ya.restaurants.cuisine;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ToString
@RequiredArgsConstructor
public class CuisineServiceImpl implements CuisineService {
    private final CuisineRepository repository;
    private final CuisineMapper mapper;


    @Override
    public Page<CuisineDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDto);
    }

    @Override
    public CuisineDto saveOrUpdate(CuisineDto cuisineDto) {
        return toDto(repository.saveAndFlush(toEntity(cuisineDto)));
    }

    @Override
    public Optional<CuisineDto> findById(long id) {
        return repository.findById(id).map(this::toDto);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }


    private CuisineDto toDto(Cuisine cuisine) {
        return mapper.toDto(cuisine);
    }

    private Cuisine toEntity(CuisineDto cuisineDto) {
        return mapper.toEntity(cuisineDto);
    }

}
