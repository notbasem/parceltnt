package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.mapstruct.factory.Mappers;

public interface TruckMapper {
    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);

    /**
     * Dto and Entity Mapping
     */
    TruckEntity dtoToEntity(Truck truck);
    Truck entityToDto(TruckEntity truckEntity);

    /**
     * Entity and Model Mapping
     */
    at.fhtw.swen3.model.entities.Truck entityToModel(TruckEntity truckEntity);
    TruckEntity modelToEntity(at.fhtw.swen3.model.entities.Truck truck);
}
