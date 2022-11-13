package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeoCoordinateRepositoryTest {
    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;
    private static GeoCoordinateEntity geoCoordinateEntity;

    @BeforeAll
    static void setUp() {
        geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(6d);
        geoCoordinateEntity.setLon(8d);
    }

    @Test
    public void saveGeocoordinateEntityTrue() {
        GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(geoCoordinateEntity);
        assertEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());
    }

    @Test
    public void saveGeocoordinateEntityFalse() {
        GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(geoCoordinateEntity);
        assertNotEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLat());
        assertNotEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLon());
    }
}
