package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WarehouseNextHopsMapperTest {
    @Test
    void testDtoToEntity() {
        // Given a WarehouseNextHops DTO
        WarehouseNextHops warehouseNextHopsDto = new WarehouseNextHops();
        warehouseNextHopsDto.setTraveltimeMins(30);

        // ... set other properties as needed

        // When the DTO is converted to an entity
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHopsDto);

        // Then the entity's properties should match the DTO's properties
        assertEquals(warehouseNextHopsDto.getTraveltimeMins(), warehouseNextHopsEntity.getTraveltimeMins());
        // ... add assertEquals for other properties as needed
    }

    @Test
    void testEntityToDto() {
        // Given a WarehouseNextHopsEntity
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();
        warehouseNextHopsEntity.setTraveltimeMins(30);
        // ... set other properties as needed

        // When the entity is converted to a DTO
        WarehouseNextHops warehouseNextHopsDto = WarehouseNextHopsMapper.INSTANCE.entityToDto(warehouseNextHopsEntity);

        // Then the DTO's properties should match the entity's properties
        assertEquals(warehouseNextHopsEntity.getTraveltimeMins(), warehouseNextHopsDto.getTraveltimeMins());
        // ... add assertEquals for other properties as needed
    }
    @Test
    void testDtoToEntity_nullValues() {
        // Given a WarehouseNextHops DTO with null properties
        WarehouseNextHops warehouseNextHopsDto = new WarehouseNextHops();
        // ... set properties to null as needed

        // When the DTO is converted to an entity
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHopsDto);

        // Then the entity's properties should also be null
        assertNull(warehouseNextHopsEntity.getTraveltimeMins());
        // ... add assertNull for other properties as needed
    }

    @Test
    void testEntityToDto_nullValues() {
        // Given a WarehouseNextHopsEntity with null properties
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();
        // ... set properties to null as needed

        // When the entity is converted to a DTO
        WarehouseNextHops warehouseNextHopsDto = WarehouseNextHopsMapper.INSTANCE.entityToDto(warehouseNextHopsEntity);

        // Then the DTO's properties should also be null
        assertNull(warehouseNextHopsDto.getTraveltimeMins());
        // ... add assertNull for other properties as needed
    }

    @Test
    void testDtoToEntity_roundTrip() {
        // Given a WarehouseNextHops DTO
        WarehouseNextHops warehouseNextHopsDto = new WarehouseNextHops();
        warehouseNextHopsDto.setTraveltimeMins(30);
        // ... set other properties as needed

        // When the DTO is converted to an entity, then back to a DTO
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHopsDto);
        WarehouseNextHops roundTripDto = WarehouseNextHopsMapper.INSTANCE.entityToDto(warehouseNextHopsEntity);

        // Then the round-tripped DTO's properties should match the original DTO's properties
        assertEquals(warehouseNextHopsDto, roundTripDto);
    }



}
