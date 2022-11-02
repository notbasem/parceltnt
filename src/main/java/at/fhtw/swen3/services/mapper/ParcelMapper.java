package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.Parcel;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    /**
     * Dto and Entity Mapping
     */
    @Mapping(source = "parcel.weight", target = "weight")
    @Mapping(source = "parcel.sender", target = "sender")
    @Mapping(source = "parcel.recipient", target = "recipient")
    ParcelEntity dtoToEntity(at.fhtw.swen3.services.dto.Parcel parcel);
    at.fhtw.swen3.services.dto.Parcel entityToDto(ParcelEntity parcelEntity);

    /**
     * Entity and Model Mapping
     */
    Parcel entityToModel(ParcelEntity parcelEntity);
    ParcelEntity modelToEntity(Parcel parcel);
}
