package ad.ya.restaurants.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Restaurant {
    private String name;
    private Cuisine cuisine;

    public void preparerRepas() {
        cuisine.preparerPlat();
        System.out.println("Repas prêt");
    }
}
