package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.model.entities.Recipient;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientMapper {
    RecipientMapper INSTANCE = Mappers.getMapper(RecipientMapper.class);

    /**
     * Dto and Entity Mapping
     */
    RecipientEntity dtoToEntity(at.fhtw.swen3.services.dto.Recipient recipient);
    at.fhtw.swen3.services.dto.Recipient entityToDto(RecipientEntity recipientEntity);

    /**
     * Entity and Model Mapping
     */
    Recipient entityToModel(RecipientEntity recipientEntity);
    RecipientEntity modelToEntity(Recipient recipient);

}
