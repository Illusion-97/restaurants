package ad.ya.restaurants.ustensiles;

import ad.ya.restaurants.generic.BaseDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Ustensile}
 */
@Value
public class UstensileDto  extends BaseDto implements Serializable {
    String name;
}
