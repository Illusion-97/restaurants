package ad.ya.restaurants.cuisine;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Cuisine}
 */
@Value
public class CuisineDto implements Serializable {
    long id;
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
