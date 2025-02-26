package ad.ya.restaurants.restaurants;

import ad.ya.restaurants.generic.GenericMapper;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantMapper extends GenericMapper<RestaurantDto,Restaurant> {

}
