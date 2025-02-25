package ad.ya.restaurants.users;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ToString
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDto);
    }

    @Override
    public UserDto saveOrUpdate(UserDto userDto) {
        return toDto(repository.saveAndFlush(toEntity(userDto)));
    }

    @Override
    public Optional<UserDto> findById(long id) {
        return repository.findById(id).map(this::toDto);
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
