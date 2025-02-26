package ad.ya.restaurants.files;

import ad.ya.restaurants.generic.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class File extends BaseEntity {
    private String nom;
    private String type;
}
