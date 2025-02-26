package ad.ya.restaurants.restaurants;

import org.mapstruct.Mapper;

@Mapper
public interface RestaurantMapper {

    RestaurantDto toDto(Restaurant restaurant);

    Restaurant toEntity(RestaurantDto restaurantDto);
}
