package ad.ya.restaurants.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Ustensile {
    private String name;

    public Ustensile() {
        System.out.println("\u001B[36mUstensile.Ustensile\u001B[0m");
    }

    public void use() {
        System.out.println(name + " utilisé");
    }
}
