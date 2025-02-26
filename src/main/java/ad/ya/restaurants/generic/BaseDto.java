package ad.ya.restaurants.generic;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseDto {
    private long id;
}
