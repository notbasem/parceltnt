package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.Error;
import at.fhtw.swen3.persistence.entity.ErrorEntity;
import org.mapstruct.factory.Mappers;

public interface ErrorMapper {
    ErrorMapper INSTANCE = Mappers.getMapper(ErrorMapper.class);

    /**
     * DTO and Entity Mapping
     */
    ErrorEntity dtoToEntity(at.fhtw.swen3.services.dto.Error error);
    at.fhtw.swen3.services.dto.Error entityToDto(ErrorEntity errorEntity);

    /**
     * Entity and Model Mapping
     */
    Error entityToModel(ErrorEntity errorEntity);
    ErrorEntity modelToEntity(Error error);
}
