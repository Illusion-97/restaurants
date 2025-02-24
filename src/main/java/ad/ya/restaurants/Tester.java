package ad.ya.restaurants;

import ad.ya.restaurants.models.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Tester {
    public Tester(Restaurant restaurant, ApplicationContext context) {
        System.out.println("restaurant = \u001B[31m" + restaurant + "\u001B[0m");
        Restaurant r = (Restaurant) context.getBean("FirstOne");
        System.out.println("r = \u001B[31m" + r + "\u001B[0m");
        Restaurant r2 = context.getBean(Restaurant.class);
        System.out.println("r2 = \u001B[31m" + r2 + "\u001B[0m");
    }
}
