package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.RecipientModel;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientMapper {
    RecipientMapper INSTANCE = Mappers.getMapper(RecipientMapper.class);

    /**
     * Dto and Entity Mapping
     */
    RecipientEntity dtoToEntity(Recipient recipient);
    Recipient entityToDto(RecipientEntity recipientEntity);

    /**
     * Entity and Model Mapping
     */
    RecipientModel entityToModel(RecipientEntity recipientEntity);
    RecipientEntity modelToEntity(RecipientModel recipientModel);

}
