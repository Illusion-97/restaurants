package ad.ya.restaurants.users;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
