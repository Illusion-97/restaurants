package ad.ya.restaurants.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class RegisterDto {
    private String pseudo;
    private String email;
    private String password;
}
