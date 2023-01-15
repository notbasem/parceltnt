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
        hopArrival.setCode("ABCD123");
        hopArrival.setDescription("Hop arrival at ABCD location");
        hopArrival.setDateTime(OffsetDateTime.now());

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrival);

        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
    }
    @Test
    public void testEntityToDtoMapping() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("ABCD123");
        hopArrivalEntity.setDescription("Hop arrival at ABCD location");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());

        HopArrival hopArrival = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        assertEquals(hopArrivalEntity.getCode(), hopArrival.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrival.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrival.getDateTime());
    }


}
