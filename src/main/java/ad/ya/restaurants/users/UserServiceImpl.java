package ad.ya.restaurants.users;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto saveOrUpdate(UserDto userDto) {
        User u = convert(userDto);
        User savedUsed = repository.saveAndFlush(u);
        return new UserDto().setId(savedUsed.getId());
    }


    private User convert(UserDto dto) {
        return new User().setId(dto.getId());
    }
}
