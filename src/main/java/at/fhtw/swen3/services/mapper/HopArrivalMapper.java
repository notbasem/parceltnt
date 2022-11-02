package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopArrival;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE = Mappers.getMapper(HopArrivalMapper.class);

    /**
     * DTO and Entity Mapping
     */
    HopArrivalEntity dtoToEntity(at.fhtw.swen3.services.dto.HopArrival hopArrival);
    at.fhtw.swen3.services.dto.HopArrival entityToDto(HopArrivalEntity hopArrivalEntity);

    /**
     * Entity and Model Mapping
     */
    HopArrival entityToModel(HopArrivalEntity hopArrivalEntity);
    HopArrivalEntity modelToEntity(HopArrival hopArrival);

}
