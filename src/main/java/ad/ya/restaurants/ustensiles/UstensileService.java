package ad.ya.restaurants.ustensiles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UstensileService {
    Page<UstensileDto> findAll(Pageable pageable);

    UstensileDto saveOrUpdate(UstensileDto ustensile);

    Optional<UstensileDto> findById(long id);

    void deleteById(long id);
}
