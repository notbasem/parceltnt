package at.fhtw.swen3.services.mapper;

import static org.junit.jupiter.api.Assertions.*;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mapstruct.factory.Mappers;

class TransferwarehouseMapperTest {
    private TransferwarehouseMapper transferwarehouseMapper = Mappers.getMapper(TransferwarehouseMapper.class);

    @Test
    public void testDtoToEntity() {
        // Create a Transferwarehouse DTO
        Transferwarehouse transferwarehouse = new Transferwarehouse();
        transferwarehouse.setRegionGeoJson("{\"type\":\"Polygon\",\"coordinates\":[[[30,10],[40,40],[20,40],[10,20],[30,10]]]}");
        transferwarehouse.setLogisticsPartner("UPS");
        transferwarehouse.setLogisticsPartnerUrl("https://www.ups.com");

        // Convert DTO to Entities
        TransferwarehouseEntity transferwarehouseEntity = transferwarehouseMapper.dtoToEntity(transferwarehouse);
        // Assert that the fields are correctly mapped
        assertNotNull(transferwarehouseEntity);
        assertEquals(transferwarehouse.getRegionGeoJson(), transferwarehouseEntity.getRegionGeoJson());
        assertEquals(transferwarehouse.getLogisticsPartner(), transferwarehouseEntity.getLogisticsPartner());
        assertEquals(transferwarehouse.getLogisticsPartnerUrl(), transferwarehouseEntity.getLogisticsPartnerUrl());
    }


    @Test
    public void testEntityToDto() {
        // Create a TransferwarehouseEntity
        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity();
        transferwarehouseEntity.setRegionGeoJson("{\"type\":\"Polygon\",\"coordinates\":[[[30,10],[40,40],[20,40],[10,20],[30,10]]]}");
        transferwarehouseEntity.setLogisticsPartner("UPS");
        transferwarehouseEntity.setLogisticsPartnerUrl("https://www.ups.com");

        // Convert Entities to DTO
        Transferwarehouse transferwarehouse = transferwarehouseMapper.entityToDto(transferwarehouseEntity);

        // Assert that the fields are correctly mapped
        assertNotNull(transferwarehouse);
        assertEquals(transferwarehouseEntity.getRegionGeoJson(), transferwarehouse.getRegionGeoJson());
        assertEquals(transferwarehouseEntity.getLogisticsPartner(), transferwarehouse.getLogisticsPartner());
        assertEquals(transferwarehouseEntity.getLogisticsPartnerUrl(), transferwarehouse.getLogisticsPartnerUrl());
    }
}
