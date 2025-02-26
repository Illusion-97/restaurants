package ad.ya.restaurants.cuisine;

import ad.ya.restaurants.generic.BaseEntity;
import ad.ya.restaurants.ustensiles.Ustensile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Cuisine extends BaseEntity {

    @ManyToMany
    private List<Ustensile> ustensiles;

}
