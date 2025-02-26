package ad.ya.restaurants.restaurants;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ToString
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository repository;
    private final RestaurantMapper mapper;


    @Override
    public Page<RestaurantDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDto);
    }

    @Override
    public RestaurantDto saveOrUpdate(RestaurantDto restaurantDto) {
        return toDto(repository.saveAndFlush(toEntity(restaurantDto)));
    }

    @Override
    public Optional<RestaurantDto> findById(long id) {
        return repository.findById(id).map(this::toDto);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }


    private RestaurantDto toDto(Restaurant restaurant) {
        return mapper.toDto(restaurant);
    }

    private Restaurant toEntity(RestaurantDto restaurantDto) {
        return mapper.toEntity(restaurantDto);
    }

}
