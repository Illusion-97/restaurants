package ad.ya.restaurants.ustensiles;

import ad.ya.restaurants.generic.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Ustensile  extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

}
