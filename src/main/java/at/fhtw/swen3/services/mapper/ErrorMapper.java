package at.fhtw.swen3.services.mapper;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper {
    ErrorMapper INSTANCE = Mappers.getMapper(ErrorMapper.class);

    /**
     * DTO and Entity Mapping
     */
    ErrorEntity dtoToEntity(Error error);
    Error entityToDto(ErrorEntity errorEntity);
}
