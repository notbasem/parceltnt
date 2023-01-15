package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WarehouseNextHopsRepositoryTest {

    @Autowired
    private WarehouseNextHopsRepository warehouseNextHopsRepository;
    @Autowired
    private HopRepository hopRepository;
    @Test
    void testFindById() {
        // given
        HopEntity hop = new HopEntity();
        hop.setHopType("Test hop type");
        hop.setCode("Test code");
        hop.setDescription("Test description");
        hop.setProcessingDelayMins(60);
        hop.setLocationName("Test location name");
        GeoCoordinateEntity geoCoordinate = new GeoCoordinateEntity();
        geoCoordinate.setLat(12.345678);
        geoCoordinate.setLon(98.765432);
        hop.setLocationCoordinates(geoCoordinate);
        hop = hopRepository.save(hop);

        WarehouseNextHopsEntity warehouseNextHops = new WarehouseNextHopsEntity();
        warehouseNextHops.setTraveltimeMins(120);
        warehouseNextHops.setHopEntity(hop);
        warehouseNextHops = warehouseNextHopsRepository.save(warehouseNextHops);

        // when
        Optional<WarehouseNextHopsEntity> foundWarehouseNextHops = warehouseNextHopsRepository.findById(hop.getId());

        // then
        assertTrue(foundWarehouseNextHops.isPresent());
        assertEquals(warehouseNextHops.getTraveltimeMins(), foundWarehouseNextHops.get().getTraveltimeMins());
        assertEquals(warehouseNextHops.getHopEntity().getHopType(), foundWarehouseNextHops.get().getHopEntity().getHopType());
        assertEquals(warehouseNextHops.getHopEntity().getCode(), foundWarehouseNextHops.get().getHopEntity().getCode());
        assertEquals(warehouseNextHops.getHopEntity().getDescription(), foundWarehouseNextHops.get().getHopEntity().getDescription());
        assertEquals(warehouseNextHops.getHopEntity().getProcessingDelayMins(), foundWarehouseNextHops.get().getHopEntity().getProcessingDelayMins());
        assertEquals(warehouseNextHops.getHopEntity().getLocationName(), foundWarehouseNextHops.get().getHopEntity().getLocationName());
        assertEquals(warehouseNextHops.getHopEntity().getLocationCoordinates().getLat(), foundWarehouseNextHops.get().getHopEntity().getLocationCoordinates().getLat());
        assertEquals(warehouseNextHops.getHopEntity().getLocationCoordinates().getLon(), foundWarehouseNextHops.get().getHopEntity().getLocationCoordinates().getLon());
    }
}


