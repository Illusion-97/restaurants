package ad.ya.restaurants.cuisine;

import ad.ya.restaurants.generic.BaseDto;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Cuisine}
 */
@Value
public class CuisineDto  extends BaseDto implements Serializable {
    List<UstensileDto> ustensiles;

    /**
     * DTO for {@link ad.ya.restaurants.ustensiles.Ustensile}
     */
    @Value
    public static class UstensileDto implements Serializable {
        long id;
        String name;
    }
}
