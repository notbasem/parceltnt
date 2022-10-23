package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.HopArrivalModel;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE = Mappers.getMapper(HopArrivalMapper.class);

    /**
     * DTO and Entity Mapping
     */
    HopArrivalEntity dtoToEntity(HopArrival hopArrival);
    HopArrival entityToDto(HopArrivalEntity hopArrivalEntity);

    /**
     * Entity and Model Mapping
     */
    HopArrivalModel entityToModel(HopArrivalEntity hopArrivalEntity);
    HopArrivalEntity modelToEntity(HopArrivalModel hopArrivalModel);

}
