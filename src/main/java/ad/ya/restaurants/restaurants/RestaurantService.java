package ad.ya.restaurants.restaurants;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RestaurantService {
    Page<RestaurantDto> findAll(Pageable pageable);

    RestaurantDto saveOrUpdate(RestaurantDto restaurant);

    Optional<RestaurantDto> findById(long id);

    void deleteById(long id);
}
