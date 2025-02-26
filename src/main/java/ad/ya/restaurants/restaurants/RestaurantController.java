package ad.ya.restaurants.restaurants;

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
@RequestMapping("restaurants")
public class RestaurantController {
    private RestaurantService service;

    @GetMapping
    public ResponseEntity<Page<RestaurantDto>> findAll(Pageable pageable) {
        Page<RestaurantDto> page = service.findAll(pageable);
        return page.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity<RestaurantDto> getById(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<RestaurantDto> saveOrUpdate(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity
                .status(restaurantDto.getId() == 0 ? HttpStatus.CREATED : HttpStatus.OK)
                .body(service.saveOrUpdate(restaurantDto));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
