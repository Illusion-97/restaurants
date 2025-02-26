package ad.ya.restaurants.cuisine;

import org.mapstruct.Mapper;

@Mapper
public interface CuisineMapper {

    CuisineDto toDto(Cuisine cuisine);

    Cuisine toEntity(CuisineDto cuisineDto);
}
