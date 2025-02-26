package ad.ya.restaurants.users;

import ad.ya.restaurants.generic.GenericController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController extends GenericController<UserDto,UserService> {
    public UserController(UserService service) {
        super(service);
    }
}
