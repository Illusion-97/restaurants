package ad.ya.restaurants.cuisine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CuisineService {
    Page<CuisineDto> findAll(Pageable pageable);

    CuisineDto saveOrUpdate(CuisineDto cuisine);

    Optional<CuisineDto> findById(long id);

    void deleteById(long id);
}
