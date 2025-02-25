package ad.ya.restaurants.users;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ToString
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto saveOrUpdate(UserDto userDto) {
        return toDto(repository.saveAndFlush(toEntity(userDto)));
    }

    private UserDto toDto(User user) {
        return mapper.toDto(user);
    }

    private User toEntity(UserDto userDto) {
        return mapper.toEntity(userDto);
    }

    private List<UserDto> toDto(List<User> users) {
        return users.stream().map(mapper::toDto).toList();
    }

}
