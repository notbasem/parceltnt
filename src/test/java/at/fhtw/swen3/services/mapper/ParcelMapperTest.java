package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Parcel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParcelMapperTest {
    private static final Logger log = LoggerFactory.getLogger(ParcelMapperTest.class);

    @Test
    void dtoToEntityTrue() {
        log.info("TEST dtoToEntity");
        final Parcel parcel = new Parcel(123L, 2.25F);
        at.fhtw.swen3.services.dto.Parcel parcelDto = ParcelMapper.INSTANCE.entityToParcelDto(parcel);
        assertEquals(parcel.getId(), parcel.getId());
        assertEquals(parcel.getWeight(), parcelDto.getWeight());
    }

}
