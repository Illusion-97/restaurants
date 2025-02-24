package ad.ya.restaurants.conf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
@ToString
// Crée un objet dans le contextede Spring basé sur les informations trouvées dans le fichier .properties
@ConfigurationProperties(prefix = "my") // prefix permet d'isoler une partie des informations à récupérer
public class MyProperties {
    private String name;
    private int age;
    private List<String> mails;
    private Map<String,String> pseudo;
    private Adresse adresse;
}
