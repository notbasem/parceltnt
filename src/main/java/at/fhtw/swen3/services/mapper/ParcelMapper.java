package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Parcel;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import at.fhtw.swen3.services.dto.ParcelDto;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    @Mapping(source = "parcelDto.weight", target = "weight")
    @Mapping(source = "parcelDto.recipient", target = "recipient")
    @Mapping(source = "parcelDto.sender", target = "sender")
    @Mapping(source = "newParcelInfoDto.trackingId", target = "trackingId")
    @Mapping(source = "trackingInformationDto.state", target = "state")
    Parcel dtoToEntity(ParcelDto parcelDto, NewParcelInfoDto newParcelInfoDto, TrackingInformationDto trackingInformationDto);

    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "recipient", target = "recipient")
    @Mapping(source = "sender", target = "sender")
    ParcelDto entityToParcelDto(Parcel parcel);

    /*
    @Mapping(source = "trackingId", target = "trackingId")
    NewParcelInfoDto entityToNewParcelInfo(Parcel parcel);

    @Mapping(source = "state", target = "state")
    TrackingInformationDto entityToTrackingInfoDto(Parcel parcel);

    ParcelDto entityToDto (Parcel parcel);
    Parcel dtoToEntity (ParcelDto parcelDto);
    */
}
