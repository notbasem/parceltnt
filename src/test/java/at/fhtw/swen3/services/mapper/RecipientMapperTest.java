package at.fhtw.swen3.services.mapper;

import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.persistence.entities.RecipientEntity;


import org.junit.jupiter.api.Test;

public class RecipientMapperTest {

    private static final String NAME = "Ahmed Barakat";
    private static final String STREET = "Am Schoepfwerkt";
    private static final String POSTAL_CODE = "A-1120";
    private static final String CITY = "Wien";
    private static final String COUNTRY = "Austria";

    @Test
    public void dtoToEntityTest() {
        // Create the DTO
        Recipient recipient = new Recipient();
        recipient.setName(NAME);
        recipient.setStreet(STREET);
        recipient.setPostalCode(POSTAL_CODE);
        recipient.setCity(CITY);
        recipient.setCountry(COUNTRY);

        // Convert to entity
        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipient);

        // Assert that the values match
        assertEquals(NAME, recipientEntity.getName());
        assertEquals(STREET, recipientEntity.getStreet());
        assertEquals(POSTAL_CODE, recipientEntity.getPostalCode());
        assertEquals(CITY, recipientEntity.getCity());
        assertEquals(COUNTRY, recipientEntity.getCountry());
    }

    @Test
    public void entityToDtoTest() {
        // Create the entity
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setName(NAME);
        recipientEntity.setStreet(STREET);
        recipientEntity.setPostalCode(POSTAL_CODE);
        recipientEntity.setCity(CITY);
        recipientEntity.setCountry(COUNTRY);

        // Convert to DTO
        Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);

        // Assert that the values match
        assertEquals(NAME, recipient.getName());
        assertEquals(STREET, recipient.getStreet());
        assertEquals(POSTAL_CODE, recipient.getPostalCode());
        assertEquals(CITY, recipient.getCity());
        assertEquals(COUNTRY, recipient.getCountry());
    }
}
