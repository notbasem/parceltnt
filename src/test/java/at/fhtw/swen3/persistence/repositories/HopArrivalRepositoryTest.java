package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopArrivalRepositoryTest {
    @Autowired
    private HopArrivalRepository hopArrivalRepository;
    private static HopArrivalEntity hopArrivalEntity;

    @BeforeAll
    static void setUp() {
        hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("A-1210");
        hopArrivalEntity.setDescription("Hi I am a description");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());
        hopArrivalEntity.setFk_parcel(null);
    }

    @Test
    public void saveHopArrivalEntityTrue() {
        HopArrivalEntity hopArrival = hopArrivalRepository.save(hopArrivalEntity);
        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
    }
}
