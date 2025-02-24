package ad.ya.restaurants.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@Component
/* @Component indique à spring qu'il doit insérer dans son contexte une instance de cette classe*/
public class Cuisine {
    private List<Ustensile> ustensiles;

    /*public Cuisine() {
        *//*ustensiles = new ArrayList<>();
        Ustensile poele = new Ustensile().setName("poele");
        Ustensile spatule = new Ustensile().setName("spatule");
        ustensiles.add(poele);
        ustensiles.add(spatule);*//*
        ustensiles = List.of(
                new Ustensile().setName("poele"),
                new Ustensile().setName("spatule")
        );
    }*/

    /*@Autowired indique à spring que les paramètres sont à récupérer dans son contexte (automatique sur un constructeur)*/
    @Autowired
    public Cuisine(Ustensile ustensile) {
        System.out.println("\u001B[36mCuisine.Cuisine\u001B[0m");
        System.out.println("ustensile = \u001B[31m" + ustensile + "\u001B[0m");
    }

    public void preparerPlat() {
        ustensiles.forEach(Ustensile::use);
        System.out.println("Plat prêt");
    }
}
