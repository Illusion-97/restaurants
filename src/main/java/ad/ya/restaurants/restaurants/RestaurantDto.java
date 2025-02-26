package ad.ya.restaurants.restaurants;

import ad.ya.restaurants.generic.BaseDto;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Restaurant}
 */
@Value
public class RestaurantDto  extends BaseDto implements Serializable {
    CuisineDto cuisine;
    String name;
    List<FileDto> cartes;

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

    /**
     * DTO for {@link ad.ya.restaurants.files.File}
     */
    @Value
    public static class FileDto implements Serializable {
        long id;
    }
}
