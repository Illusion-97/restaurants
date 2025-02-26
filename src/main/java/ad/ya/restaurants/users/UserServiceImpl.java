package ad.ya.restaurants.users;

import ad.ya.restaurants.generic.GenericServiceImpl;
import lombok.ToString;
import org.springframework.stereotype.Service;


@Service
@ToString
public class UserServiceImpl
        extends GenericServiceImpl<
        User,
        UserDto,
        UserRepository,
        UserMapper
        >
        implements UserService {
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }
}
