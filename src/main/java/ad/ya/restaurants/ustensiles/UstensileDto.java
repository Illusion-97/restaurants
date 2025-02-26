package ad.ya.restaurants.ustensiles;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Ustensile}
 */
@Value
public class UstensileDto implements Serializable {
    long id;
    String name;
}
