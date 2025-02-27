package ad.ya.restaurants.users;

import ad.ya.restaurants.generic.GenericServiceImpl;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        implements UserService, UserDetailsService {
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find user :" + email));
    }
}
