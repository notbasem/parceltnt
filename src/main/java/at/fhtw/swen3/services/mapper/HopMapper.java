package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.Hop;
import at.fhtw.swen3.persistence.entity.HopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper {
    HopMapper INSTANCE = Mappers.getMapper(HopMapper.class);

    /**
     * Dto and Entity Mapping
     */
    HopEntity dtoToEntity(at.fhtw.swen3.services.dto.Hop hop);
    at.fhtw.swen3.services.dto.Hop entityToDto(HopEntity hopEntity);

    /**
     * Entity and Model Mapping
     */
    Hop entityToModel(HopEntity hopEntity);
    HopEntity modelToEntity(Hop hop);
}
