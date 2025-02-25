package ad.ya.restaurants.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Page<UserDto> findAll(Pageable pageable);
    UserDto saveOrUpdate(UserDto user);
    Optional<UserDto> findById(long id);
}
