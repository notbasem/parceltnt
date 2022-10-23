package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.ParcelModel;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewParcelInfoMapper {
    NewParcelInfoMapper INSTANCE = Mappers.getMapper(NewParcelInfoMapper.class);

    /**
     * Dto and Entity Mapping
     */
    ParcelEntity dtoToEntity (NewParcelInfo newParcelInfo);
    NewParcelInfo entityToDto (ParcelEntity parcelEntity);
}
