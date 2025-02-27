package ad.ya.restaurants.users;

import ad.ya.restaurants.generic.GenericController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController extends GenericController<UserDto,UserService> {
    public UserController(UserService service) {
        super(service);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ResponseEntity<Page<UserDto>> findAll(Pageable pageable) {
        return super.findAll(pageable);
    }

    @Override
    public ResponseEntity<UserDto> saveOrUpdate(UserDto dto) {
        throw new RuntimeException("Accès refusé. Utilisez la méthode d'inscription.");
    }
}
