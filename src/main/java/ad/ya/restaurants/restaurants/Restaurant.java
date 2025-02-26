package ad.ya.restaurants.restaurants;

import ad.ya.restaurants.cuisine.Cuisine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cuisine cuisine;
    @Column(unique = true, nullable = false)
    private String name;

}
