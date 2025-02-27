package ad.ya.restaurants.auth;

import ad.ya.restaurants.users.User;
import ad.ya.restaurants.users.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(/*uses = {UserMapper.class}*/)
public interface AuthMapper {

    @Mapping(source = ".", target = "user")
    @Mapping(target = "token", expression = "java(ad.ya.restaurants.tools.JwtUtils.generateToken(user))")
    AuthResponse toResponse(User user);

    User toUser(RegisterDto dto);
}
