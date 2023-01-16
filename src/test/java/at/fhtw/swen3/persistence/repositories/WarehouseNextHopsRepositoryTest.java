package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class WarehouseNextHopsRepositoryTest {

    @MockBean
    private WarehouseNextHopsRepository repository;

    @Test
    public void testFindById() {
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        entity.setTraveltimeMins(30);
        entity.setHop(new HopEntity());
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(entity));
        Optional<WarehouseNextHopsEntity> result = repository.findById(1L);
        assertEquals(result.get().getTraveltimeMins(), entity.getTraveltimeMins());
    }
}
