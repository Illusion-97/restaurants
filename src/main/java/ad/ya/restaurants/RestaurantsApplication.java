package ad.ya.restaurants;


import ad.ya.restaurants.models.Cuisine;
import ad.ya.restaurants.models.Ustensile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.List;


@SpringBootApplication
// Active la lecture du fichier properties pour la création d'objet basés sur ce dernier
@ConfigurationPropertiesScan("ad.ya.restaurants.conf")
//@Profile("dev") : Utilisable mais pau maintenable
public class RestaurantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantsApplication.class, args);
    }


    @Bean
    @Primary
    // Si plusieurs beans du même type existent, celui annoté de Primary sera utilisé en priorité
    public Ustensile casserole() {
        return new Ustensile().setName("casserole");
    }

    /* @Bean indique à spring qu'il doit insérer dans son contexte l'objet retourné par la méthode*/
    @Bean
    public Ustensile poelle() {
        return new Ustensile().setName("poelle");
    }
    
    @Bean
    public Cuisine c1(@Qualifier("poelle") Ustensile ustensile) {
        return new Cuisine(ustensile);
    }

}
