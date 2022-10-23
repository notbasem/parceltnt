package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.GeoCoordinateModel;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {
    GeoCoordinateMapper INSTANCE = Mappers.getMapper(GeoCoordinateMapper.class);

    /**
     * DTO and Entity Mapping
     */
    GeoCoordinateEntity dtoToEntity(GeoCoordinate geoCoordinate);
    GeoCoordinate entityToDto(GeoCoordinateEntity geoCoordinateEntity);

    /**
     * Entity and Model Mapping
     */
    GeoCoordinateModel entityToModel(GeoCoordinateEntity geoCoordinateEntity);
    GeoCoordinateEntity modelToEntity(GeoCoordinateModel geoCoordinateModel);

}
