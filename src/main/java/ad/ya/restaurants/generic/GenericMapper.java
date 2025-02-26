package ad.ya.restaurants.generic;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GenericMapper<D extends BaseDto,E extends BaseEntity> {

    D toDto(E entity);

    E toEntity(D dto);
}
