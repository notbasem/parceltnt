package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.repositories.TruckRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class TruckRepositoryTest {

    @MockBean
    private TruckRepository repository;

    @Test
    public void testFindById() {
        TruckEntity entity = new TruckEntity();
        entity.setId(1L);
        entity.setRegionGeoJson("{\"type\":\"Point\",\"coordinates\":[30.5,50.5]}");
        entity.setNumberPlate("XXX-XXX");
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entity));
        Optional<TruckEntity> result = repository.findById(1L);
        assertEquals(result.get().getId(), entity.getId());
        assertEquals(result.get().getRegionGeoJson(), entity.getRegionGeoJson());
        assertEquals(result.get().getNumberPlate(), entity.getNumberPlate());
    }
}

