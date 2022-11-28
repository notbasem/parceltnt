package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopRepositoryTest {
    @Autowired
    private HopRepository hopRepository;
    private static HopEntity hopEntity;

    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;

    @BeforeAll
    static void setUp() {
        hopEntity = new HopEntity();
        hopEntity.setHopType("Hop");
        hopEntity.setCode("ABC");
        hopEntity.setDescription("Hi I am a description");
        hopEntity.setProcessingDelayMins(8);
        hopEntity.setLocationName("ABC-Location");
    }

    @Test
    public void saveHopEntityTrue() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(6d);
        geoCoordinateEntity.setLon(8d);
        geoCoordinateRepository.save(geoCoordinateEntity);

        hopEntity.setLocationCoordinates(geoCoordinateEntity);
        HopEntity hop = hopRepository.save(hopEntity);
        assertEquals(hop.getHopType(), hopEntity.getHopType());
        assertEquals(hop.getCode(), hopEntity.getCode());
        assertEquals(hop.getDescription(), hopEntity.getDescription());
        assertEquals(hop.getDescription(), hopEntity.getDescription());
        assertEquals(hop.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
        assertEquals(hop.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }
}
