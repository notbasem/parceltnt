package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Parcel;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    @Mapping(source = "parcel.weight", target = "weight")
    @Mapping(source = "parcel.recipient", target = "recipient")
    @Mapping(source = "parcel.sender", target = "sender")
    @Mapping(source = "newParcelInfo.trackingId", target = "trackingId")
    @Mapping(source = "trackingInformation.state", target = "state")
    Parcel dtoToEntity(at.fhtw.swen3.services.dto.Parcel parcel, NewParcelInfo newParcelInfo, TrackingInformation trackingInformation);


    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "recipient", target = "recipient")
    @Mapping(source = "sender", target = "sender")
    at.fhtw.swen3.services.dto.Parcel entityToParcelDto(Parcel parcel);

    /*
    @Mapping(source = "trackingId", target = "trackingId")
    NewParcelInfoDto entityToNewParcelInfo(Parcel parcel);

    @Mapping(source = "state", target = "state")
    TrackingInformationDto entityToTrackingInfoDto(Parcel parcel);

    ParcelDto entityToDto (Parcel parcel);
    Parcel dtoToEntity (ParcelDto parcelDto);
    */
}
