package ad.ya.restaurants.ustensiles;

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
@RequestMapping("ustensiles")
public class UstensileController {
    private UstensileService service;

    @GetMapping
    public ResponseEntity<Page<UstensileDto>> findAll(Pageable pageable) {
        Page<UstensileDto> page = service.findAll(pageable);
        return page.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity<UstensileDto> getById(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<UstensileDto> saveOrUpdate(@RequestBody UstensileDto ustensileDto) {
        return ResponseEntity
                .status(ustensileDto.getId() == 0 ? HttpStatus.CREATED : HttpStatus.OK)
                .body(service.saveOrUpdate(ustensileDto));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
