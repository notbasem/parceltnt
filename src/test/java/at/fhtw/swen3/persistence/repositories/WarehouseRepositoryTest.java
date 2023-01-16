package at.fhtw.swen3.persistence.repositories;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class WarehouseRepositoryTest {

    @MockBean
    private WarehouseRepository repository;

    @Test
    public void testFindById() {
        WarehouseEntity entity = new WarehouseEntity();
        if (entity.getNextHops() == null) {
            entity.setNextHops(new ArrayList<>());
        }
        entity.setId(1L);
        entity.setLevel(1);
        entity.getNextHops().add(new WarehouseNextHopsEntity());
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entity));
        Optional<WarehouseEntity> result = repository.findById(1L);
        assertEquals(result.get().getId(), entity.getId());
        assertEquals(result.get().getLevel(), entity.getLevel());
        assertEquals(result.get().getNextHops().size(), entity.getNextHops().size());
    }
}




