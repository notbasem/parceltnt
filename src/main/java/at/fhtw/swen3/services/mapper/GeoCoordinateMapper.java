package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.GeoCoordinate;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {
    GeoCoordinateMapper INSTANCE = Mappers.getMapper(GeoCoordinateMapper.class);

    /**
     * DTO and Entity Mapping
     */
    GeoCoordinateEntity dtoToEntity(at.fhtw.swen3.services.dto.GeoCoordinate geoCoordinate);
    at.fhtw.swen3.services.dto.GeoCoordinate entityToDto(GeoCoordinateEntity geoCoordinateEntity);

    /**
     * Entity and Model Mapping
     */
    GeoCoordinate entityToModel(GeoCoordinateEntity geoCoordinateEntity);
    GeoCoordinateEntity modelToEntity(GeoCoordinate geoCoordinate);

}
