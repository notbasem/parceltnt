package at.fhtw.swen3.services.mapper;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseNextHopsMapperTest {
    @Test
    void testDtoToEntity() {
        // Given a valid WarehouseNextHops DTO
        WarehouseNextHops dto = new WarehouseNextHops();
        dto.setTraveltimeMins(30);
        Hop hop = new Hop();
        hop.setHopType("transferwarehouse");
        hop.setCode("TWH1");
        hop.setDescription("Transfer Warehouse 1");
        dto.setHop(hop);

        // When the DTO is mapped to an entity
        WarehouseNextHopsEntity entity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(dto);

        // Then the entity's fields should match the DTO's fields
        assertEquals(dto.getTraveltimeMins(), entity.getTraveltimeMins());
        assertEquals(dto.getHop().getHopType(), entity.getHopEntity().getHopType());
        assertEquals(dto.getHop().getCode(), entity.getHopEntity().getCode());
        assertEquals(dto.getHop().getDescription(), entity.getHopEntity().getDescription());
    }

    @Test
    void testEntityToDto() {
        // Given a valid WarehouseNextHopsEntity
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        entity.setTraveltimeMins(30);
        HopEntity hop = new HopEntity();
        hop.setHopType("transferwarehouse");
        hop.setCode("TWH1");
        hop.setDescription("Transfer Warehouse 1");
        entity.setHopEntity(hop);

        // When the entity is mapped to a DTO
        WarehouseNextHops dto = WarehouseNextHopsMapper.INSTANCE.entityToDto(entity);

        // Then the DTO's fields should match the entity's fields
        assertEquals(entity.getTraveltimeMins(), dto.getTraveltimeMins());
        assertEquals(entity.getHopEntity().getHopType(), dto.getHop().getHopType());
        assertEquals(entity.getHopEntity().getCode(), dto.getHop().getCode());
        assertEquals(entity.getHopEntity().getDescription(), dto.getHop().getDescription());
    }


}