package ad.ya.restaurants.cuisine;

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
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToMany
    private List<Ustensile> ustensiles;

}
