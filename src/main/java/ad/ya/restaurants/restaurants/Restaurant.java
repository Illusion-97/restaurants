package ad.ya.restaurants.restaurants;

import ad.ya.restaurants.cuisine.Cuisine;
import ad.ya.restaurants.files.File;
import ad.ya.restaurants.generic.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Restaurant extends BaseEntity {

    @ManyToOne
    private Cuisine cuisine;
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany
    private List<File> cartes;

    public Restaurant addCarte(File carte) {
        cartes.add(carte);
        return this;
    }
}
