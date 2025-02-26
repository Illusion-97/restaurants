package ad.ya.restaurants.users;

import ad.ya.restaurants.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper extends GenericMapper<UserDto,User> {

}
