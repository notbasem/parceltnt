package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.factory.Mappers;

public interface WarehouseMapper {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    /**
     * Dto and Entity Mapping
     */
    WarehouseEntity dtoToEntity(Warehouse warehouse);
    Warehouse entityToDto(WarehouseEntity warehouseEntity);

    /**
     * Entity and Model Mapping
     */
    at.fhtw.swen3.model.entities.Warehouse entityToModel(WarehouseEntity warehouseEntity);
    WarehouseEntity modelToEntity(at.fhtw.swen3.model.entities.Warehouse warehouse);
}
