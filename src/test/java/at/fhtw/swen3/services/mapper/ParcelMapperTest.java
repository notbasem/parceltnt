package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.entity.Parcel;
import at.fhtw.swen3.services.dto.ParcelDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ParcelMapperTest {
    private static final Logger log = LoggerFactory.getLogger(ParcelMapperTest.class);

    @Test
    void dtoToEntityTrue() {
        log.info("TEST dtoToEntity");
        final Parcel parcel = new Parcel(123L, 2.25F);
        ParcelDto parcelDto = ParcelMapper.INSTANCE.entityToParcelDto(parcel);
        assertEquals(parcel.getId(), parcelDto.getId());
        assertEquals(parcel.getWeight(), parcelDto.getWeight());
    }

    @Test
    void dtoToEntityFalse() {
        log.info("TEST dtoToEntity");
        final Parcel parcel = new Parcel(123L, 2.25F);
        ParcelDto parcelDto = ParcelMapper.INSTANCE.entityToParcelDto(parcel);
        assertNotEquals(321L, parcelDto.getId());
        assertNotEquals(1.0F, parcelDto.getWeight());
    }

}
