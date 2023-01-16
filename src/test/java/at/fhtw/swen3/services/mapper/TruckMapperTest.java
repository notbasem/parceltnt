package at.fhtw.swen3.services.mapper;

import static org.junit.jupiter.api.Assertions.*;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class TruckMapperTest {
    private TruckMapper truckMapper = Mappers.getMapper(TruckMapper.class);

    @Test
    public void testDtoToEntity() {
        // Create a Truck DTO
        Truck truck = new Truck();
        truck.setRegionGeoJson("{\"type\":\"Polygon\",\"coordinates\":[[[30,10],[40,40],[20,40],[10,20],[30,10]]]}");
        truck.setNumberPlate("ABC123");

        // Convert DTO to Entities
        TruckEntity truckEntity = truckMapper.dtoToEntity(truck);
        // Assert that the fields are correctly mapped
        assertNotNull(truckEntity);
        assertEquals(truck.getRegionGeoJson(), truckEntity.getRegionGeoJson());
        assertEquals(truck.getNumberPlate(), truckEntity.getNumberPlate());
    }


    @Test
    public void testEntityToDto() {
        // Create a TruckEntity
        TruckEntity truckEntity = new TruckEntity();
        truckEntity.setRegionGeoJson("{\"type\":\"Polygon\",\"coordinates\":[[[30,10],[40,40],[20,40],[10,20],[30,10]]]}");
        truckEntity.setNumberPlate("ABC123");

        // Convert Entities to DTO
        Truck truck = TruckMapper.INSTANCE.entityToDto(truckEntity);

        // Assert that the fields are correctly mapped
        assertNotNull(truck);
        assertEquals(truckEntity.getRegionGeoJson(), truck.getRegionGeoJson());
        assertEquals(truckEntity.getNumberPlate(), truck.getNumberPlate());
    }
}
