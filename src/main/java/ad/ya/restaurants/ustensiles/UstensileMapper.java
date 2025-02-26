package ad.ya.restaurants.ustensiles;

import org.mapstruct.Mapper;

@Mapper
public interface UstensileMapper {

    UstensileDto toDto(Ustensile ustensile);

    Ustensile toEntity(UstensileDto ustensileDto);
}
