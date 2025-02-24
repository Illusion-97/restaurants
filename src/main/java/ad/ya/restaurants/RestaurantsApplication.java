package ad.ya.restaurants;

import ad.ya.restaurants.models.Cuisine;
import ad.ya.restaurants.models.Restaurant;
import ad.ya.restaurants.models.Ustensile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class RestaurantsApplication {
    private static Map<String,Object> context;

    public static void main(String[] args) {
        //SpringApplication.run(RestaurantsApplication.class, args);
        /*Restaurant r = new Restaurant();
        r.preparerRepas();
        new Restaurant()
                .setCuisine(
                        new Cuisine()
                                .setUstensiles(List.of(
                                        new Ustensile().setName("casserole"),
                                        new Ustensile().setName("louche")
                                ))
                )
                .preparerRepas();*/
        init();
        Restaurant poeleSpat = (Restaurant) context.get("Poele&Spat");
        poeleSpat.preparerRepas();
        ((Restaurant) context.get("Cass&Louche")).preparerRepas();
        new Restaurant().setCuisine(new Cuisine().setUstensiles(List.of( (Ustensile) context.get("casserole"))));
    }

    public static void init() {
        Ustensile poele = new Ustensile().setName("poele");
        Ustensile spatule = new Ustensile().setName("spatule");
        Ustensile casserole = new Ustensile().setName("casserole");
        Ustensile louche = new Ustensile().setName("louche");

        Cuisine c1 = new Cuisine().setUstensiles(List.of(poele, spatule));
        Cuisine c2 = new Cuisine().setUstensiles(List.of(casserole, louche));

        Restaurant r1 = new Restaurant().setName("Poele&Spat").setCuisine(c1);
        Restaurant r2 = new Restaurant().setName("Cass&Louche").setCuisine(c2);

        context = Map.of(
                "Poele&Spat", r1,
                "Cass&Louche", r2,
                "C1", c1,
                "C2", c2,
                "poele", poele,
                "spatule", spatule,
                "casserole", casserole,
                "louche", louche
        );
    }

}
