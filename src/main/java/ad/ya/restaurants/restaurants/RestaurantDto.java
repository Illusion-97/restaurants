package ad.ya.restaurants.restaurants;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Restaurant}
 */
@Value
public class RestaurantDto implements Serializable {
    long id;
    CuisineDto cuisine;
    String name;

    /**
     * DTO for {@link ad.ya.restaurants.cuisine.Cuisine}
     */
    @Value
    public static class CuisineDto implements Serializable {
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
}
