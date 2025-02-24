package ad.ya.restaurants.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
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

    public void preparerPlat() {
        ustensiles.forEach(Ustensile::use);
        System.out.println("Plat prêt");
    }
}
