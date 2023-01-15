package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TruckRepositoryTest {

    @Autowired
    private TruckRepository truckRepository;

    @Test
    void testFindById() {
        // given
        TruckEntity truck = new TruckEntity();
        truck.setRegionGeoJson("Test region");
        truck.setNumberPlate("Test number plate");
        truck = truckRepository.save(truck);

        // when
        Optional<TruckEntity> foundTruck = truckRepository.findById(truck.getId());

        // then
        assertTrue(foundTruck.isPresent());
        assertEquals(truck.getRegionGeoJson(), foundTruck.get().getRegionGeoJson());
        assertEquals(truck.getNumberPlate(), foundTruck.get().getNumberPlate());
    }
}

