package ad.ya.restaurants.users;

import ad.ya.restaurants.generic.BaseDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto extends BaseDto {
    private String pseudo;
    private String email;
    private String password;
    private Role role;
}
