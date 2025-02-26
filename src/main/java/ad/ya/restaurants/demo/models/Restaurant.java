package ad.ya.restaurants.demo.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@RequiredArgsConstructor // crée un constructeur avec les attributs "final" ou annotés avec @NonNull
@Component("FirstOne") // Bean nommé dans le contexte
public class Restaurant {
    private final Cuisine cuisine;
    private String name;

    public void preparerRepas() {
        cuisine.preparerPlat();
        System.out.println("Repas prêt");
    }
}
