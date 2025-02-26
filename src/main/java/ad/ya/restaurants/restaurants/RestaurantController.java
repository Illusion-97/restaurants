package ad.ya.restaurants.restaurants;

import ad.ya.restaurants.generic.GenericController;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("restaurants")
public class RestaurantController extends GenericController<RestaurantDto,RestaurantService> {

    public RestaurantController(RestaurantService service) {
        super(service);
    }

    @PostMapping(value= "{id}/cartes", consumes = "multipart/form-data")
    public void addCarte(@PathVariable long id, @RequestParam MultipartFile carte) {
        service.addCarte(id,carte);
    }
}
