package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParcelMapperTest {
    private static final Logger log = LoggerFactory.getLogger(ParcelMapperTest.class.getSimpleName());

    @Test
    void dtoToEntity() {
        //List<HopArrivalEntity> hopArrivals = new ArrayList<>().add(new HopArrivalEntity(123L, "hallo", ));
        log.info("Test dtoToEntity()");
        final Parcel parcel = new Parcel()
                .weight(2.0f)
                .sender(new Recipient()
                                .name("Herbert")
                                .city("Vienna"))
                .recipient(new Recipient()
                        .name("Gustav")
                        .city("Berlin")
                );

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        assertEquals(parcel.getWeight(), parcelEntity.getWeight());
        assertEquals(parcel.getSender().getName(), parcelEntity.getSender().getName());
        assertEquals(parcel.getSender().getCity(), parcelEntity.getSender().getCity());
    }

    @Test
    void dtoToEntityEmptyStreet() {
        log.info("Test dtoToEntityEmptyStreet()");
        final Parcel parcel = new Parcel()
                .weight(2.0f)
                .sender(new Recipient()
                        .name("Herbert")
                        .city("Vienna"))
                .recipient(new Recipient()
                        .name("Gustav")
                        .city("Berlin")
                );

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        assertNull(parcelEntity.getSender().getStreet());
    }

    @Test
    void entityToDto() {
        log.info("Test entityToDto()");

        final ParcelEntity parcelEntity = new ParcelEntity()
                .weight(2.0f)
                .sender(new RecipientEntity()
                        .name("Herbert")
                        .city("Vienna"))
                .recipient(new RecipientEntity()
                        .name("Gustav")
                        .city("Berlin")
                );

        Parcel parcel = ParcelMapper.INSTANCE.entityToDto(parcelEntity);

        assertEquals(parcelEntity.getWeight(), parcel.getWeight());
        assertEquals(parcelEntity.getSender().getCity(), parcel.getSender().getCity());
        assertNull(parcel.getSender().getStreet());
    }
}
