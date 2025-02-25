package ad.ya.restaurants.users;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ToString
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(Pageable pageable) {
        Page<UserDto> page = service.findAll(pageable);
        if(page.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(page);
    }

    @GetMapping( "{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> saveOrUpdate(@RequestBody UserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveOrUpdate(userDto));
    }


}
