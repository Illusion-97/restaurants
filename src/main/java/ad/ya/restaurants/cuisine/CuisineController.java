package ad.ya.restaurants.cuisine;

import ad.ya.restaurants.generic.GenericController;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ToString
@RequestMapping("cuisines")
public class CuisineController extends GenericController<CuisineDto,CuisineService> {

    public CuisineController(CuisineService service) {
        super(service);
    }
}
