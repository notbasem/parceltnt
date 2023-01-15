package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = HopMapper.class)
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);

    /**
     * Dto and Entity Mapping
     */
    TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse);
    Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity);
}
