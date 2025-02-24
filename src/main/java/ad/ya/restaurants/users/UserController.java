package ad.ya.restaurants.users;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ToString
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDto> saveOrUpdate(@RequestBody UserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveOrUpdate(userDto));
    }
}
