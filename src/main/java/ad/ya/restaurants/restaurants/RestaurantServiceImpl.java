package ad.ya.restaurants.restaurants;

import ad.ya.restaurants.files.FileService;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class RestaurantServiceImpl
        extends GenericServiceImpl<
        Restaurant,
        RestaurantDto,
        RestaurantRepository,
        RestaurantMapper
        >
        implements RestaurantService {
    private final FileService fileService;
    public RestaurantServiceImpl(RestaurantRepository repository, RestaurantMapper mapper, FileService fileService) {
        super(repository, mapper);
        this.fileService = fileService;
    }

    @Override
    public void addCarte(long id, MultipartFile carte) {
        repository.findById(id).ifPresent(restaurant -> saveCarte(carte, restaurant));
    }

    private Restaurant saveCarte(MultipartFile carte, Restaurant restaurant) {
        return repository.save(restaurant.addCarte(fileService.saveFile(carte, "carte")));
    }
}
