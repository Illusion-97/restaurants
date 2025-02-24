package ad.ya.restaurants.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Ustensile {
    private String name;

    public void use() {
        System.out.println(name + " utilisé");
    }
}
