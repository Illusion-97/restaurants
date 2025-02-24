package ad.ya.restaurants;

import ad.ya.restaurants.conf.MyProperties;
import ad.ya.restaurants.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Tester {

    /*@Value peut servir à affecter directement une valeur arbitraire ou présente dans application.properties*/
    @Value("${spring.application.name}")
    private String name;

    MyProperties myProperties;

    public Tester(Restaurant restaurant, ApplicationContext context, @Value("Name") String name, MyProperties myProperties) {
        /*System.out.println("restaurant = \u001B[31m" + restaurant + "\u001B[0m");
        Restaurant r = (Restaurant) context.getBean("FirstOne");
        System.out.println("r = \u001B[31m" + r + "\u001B[0m");
        Restaurant r2 = context.getBean(Restaurant.class);
        System.out.println("r2 = \u001B[31m" + r2 + "\u001B[0m");*/
        this.myProperties = myProperties;

        System.out.println("name = \u001B[31m" + this.name + "\u001B[0m");
        this.name = name;
        System.out.println("name = \u001B[31m" + this.name + "\u001B[0m");

    }

    @EventListener
    public void postStart(ApplicationStartedEvent event) {
        System.out.println("name = \u001B[31m" + this.name + "\u001B[0m");
        System.out.println("My Properties : ");
        System.out.println("myProperties = \u001B[31m" + myProperties + "\u001B[0m");
    }
}
