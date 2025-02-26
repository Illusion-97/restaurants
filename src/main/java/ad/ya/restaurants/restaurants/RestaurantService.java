package ad.ya.restaurants.restaurants;

import ad.ya.restaurants.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface RestaurantService extends GenericService<RestaurantDto> {
    void addCarte(long id, MultipartFile carte);
}
