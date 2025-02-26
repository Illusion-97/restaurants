package ad.ya.restaurants.ustensiles;

import ad.ya.restaurants.generic.GenericController;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ustensiles")
public class UstensileController extends GenericController<UstensileDto,UstensileService> {

    public UstensileController(UstensileService service) {
        super(service);
    }
}
