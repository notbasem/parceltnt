package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.factory.Mappers;

public interface WarehouseNextHopsMapper {
    WarehouseNextHopsMapper INSTANCE = Mappers.getMapper(WarehouseNextHopsMapper.class);

    /**
     * Dto and Entity Mapping
     */
    WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops warehouseNextHops);
    WarehouseNextHops entityToDto(WarehouseNextHopsEntity warehouseNextHopsEntity);

    /**
     * Entity and Model Mapping
     */
    at.fhtw.swen3.model.entities.WarehouseNextHops entityToModel(WarehouseNextHopsEntity warehouseNextHopsEntity);
    WarehouseNextHopsEntity modelToEntity(at.fhtw.swen3.model.entities.WarehouseNextHops warehouseNextHops);
}
