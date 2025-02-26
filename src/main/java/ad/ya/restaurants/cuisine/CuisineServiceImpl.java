package ad.ya.restaurants.cuisine;

import ad.ya.restaurants.generic.GenericServiceImpl;
import ad.ya.restaurants.users.User;
import ad.ya.restaurants.users.UserDto;
import ad.ya.restaurants.users.UserMapper;
import ad.ya.restaurants.users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuisineServiceImpl
        extends GenericServiceImpl<
        Cuisine,
        CuisineDto,
        CuisineRepository,
        CuisineMapper
        >
        implements CuisineService {

    public CuisineServiceImpl(CuisineRepository repository, CuisineMapper mapper) {
        super(repository, mapper);
    }
}
