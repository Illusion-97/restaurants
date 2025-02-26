package ad.ya.restaurants.ustensiles;

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
public class UstensileServiceImpl
        extends GenericServiceImpl<
        Ustensile,
        UstensileDto,
        UstensileRepository,
        UstensileMapper
        >
        implements UstensileService {
    public UstensileServiceImpl(UstensileRepository repository, UstensileMapper mapper) {
        super(repository, mapper);
    }
}
