package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.factory.Mappers;

public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);

    /**
     * Dto and Entity Mapping
     */
    TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse);
    Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity);

    /**
     * Entity and Model Mapping
     */
    at.fhtw.swen3.model.entities.Transferwarehouse entityToModel(TransferwarehouseEntity transferwarehouseEntity);
    TransferwarehouseEntity modelToEntity(at.fhtw.swen3.model.entities.Transferwarehouse transferwarehouse);

}
