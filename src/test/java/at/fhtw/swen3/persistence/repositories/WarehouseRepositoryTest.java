package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class WarehouseRepositoryTest {

    @Autowired
    private WarehouseRepository warehouseRepository;

    private WarehouseEntity warehouse;

    @BeforeEach
    void setUp() {
        GeoCoordinateEntity locationCoordinates = new GeoCoordinateEntity();
        locationCoordinates.setLat(50.0);
        locationCoordinates.setLon(10.0);

        warehouse = new WarehouseEntity();
        warehouse.setLevel(1);
        warehouse.setLocationCoordinates(locationCoordinates);
        warehouse.setDescription("Test warehouse");
        warehouse.setCode("TEST");
        warehouse.setHopType("Warehouse");
        warehouse.setProcessingDelayMins(30);
        warehouse.setLocationName("Test location");
    }

    @Test
    void whenSaveWarehouse_thenReturnWarehouse() {
        // When
        WarehouseEntity savedWarehouse = warehouseRepository.save(warehouse);

        // Then
        assertThat(savedWarehouse.getId()).isNotNull();
        assertThat(savedWarehouse.getLevel()).isEqualTo(1);
        assertThat(savedWarehouse.getLocationCoordinates().getLat()).isEqualTo(50.0);
        assertThat(savedWarehouse.getDescription()).isEqualTo("Test warehouse");
        assertThat(savedWarehouse.getCode()).isEqualTo("TEST");
        assertThat(savedWarehouse.getHopType()).isEqualTo("Warehouse");
        assertThat(savedWarehouse.getProcessingDelayMins()).isEqualTo(30);
        assertThat(savedWarehouse.getLocationName()).isEqualTo("Test location");

        // Clean up
        warehouseRepository.delete(savedWarehouse);
    }

    @Test
    void whenFindById_thenReturnWarehouse() {
        // Given
        WarehouseEntity savedWarehouse = warehouseRepository.save(warehouse);

        // When
        Optional<WarehouseEntity> foundWarehouse = warehouseRepository.findById(savedWarehouse.getId());

        // Then
        assertThat(foundWarehouse.isPresent()).isTrue();
        assertThat(foundWarehouse.get().getId()).isEqualTo(savedWarehouse.getId());
        assertThat(foundWarehouse.get().getLevel()).isEqualTo(1);
        assertThat(foundWarehouse.get().getLocationCoordinates().getLat()).isEqualTo(50.0);
        assertThat(foundWarehouse.get().getDescription()).isEqualTo("Test warehouse");
        assertThat(foundWarehouse.get().getCode()).isEqualTo("TEST");
        assertThat(foundWarehouse.get().getHopType()).isEqualTo("Warehouse");
        assertThat(foundWarehouse.get().getProcessingDelayMins()).isEqualTo(30);
        assertThat(foundWarehouse.get().getLocationName()).isEqualTo("Test location");

        // Clean up
        warehouseRepository.delete(savedWarehouse);
    }
}



