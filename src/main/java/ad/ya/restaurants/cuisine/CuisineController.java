package ad.ya.restaurants.cuisine;

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
@RequestMapping("cuisines")
public class CuisineController {
    private CuisineService service;

    @GetMapping
    public ResponseEntity<Page<CuisineDto>> findAll(Pageable pageable) {
        Page<CuisineDto> page = service.findAll(pageable);
        return page.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity<CuisineDto> getById(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<CuisineDto> saveOrUpdate(@RequestBody CuisineDto cuisineDto) {
        return ResponseEntity
                .status(cuisineDto.getId() == 0 ? HttpStatus.CREATED : HttpStatus.OK)
                .body(service.saveOrUpdate(cuisineDto));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
