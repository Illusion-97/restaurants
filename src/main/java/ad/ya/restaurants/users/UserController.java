package ad.ya.restaurants.users;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
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
        return page.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(page);
    }

    @GetMapping( "{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }


    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public ResponseEntity<UserDto> saveOrUpdate(@RequestBody UserDto userDto) {
        return ResponseEntity
                .status(userDto.getId() == 0 ? HttpStatus.CREATED : HttpStatus.OK)
                .body(service.saveOrUpdate(userDto));
    }

    @DeleteMapping( "{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
