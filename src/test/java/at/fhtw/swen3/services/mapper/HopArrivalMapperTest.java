package at.fhtw.swen3.services.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import java.time.OffsetDateTime;

public class HopArrivalMapperTest {

    @Test
    public void testDtoToEntityMapping() {
        HopArrival hopArrival = new HopArrival();
        hopArrival.setCode("A-1210");
        hopArrival.setDescription("Hop arrival at 1210 location");
        hopArrival.setDateTime(OffsetDateTime.now());

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrival);

        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
    }
    @Test
    public void testEntityToDtoMapping() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("A-1210");
        hopArrivalEntity.setDescription("Hop arrival at 1210 location");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());

        HopArrival hopArrival = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        assertEquals(hopArrivalEntity.getCode(), hopArrival.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrival.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrival.getDateTime());
    }


}
