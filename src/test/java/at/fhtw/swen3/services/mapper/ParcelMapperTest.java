package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
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

class ParcelMapperTest {
    private static final Logger log = LoggerFactory.getLogger(ParcelMapperTest.class);

    @Test
    void dtoToEntityTrue() {
        //List<HopArrivalEntity> hopArrivals = new ArrayList<>().add(new HopArrivalEntity(123L, "hallo", ));
        log.info("TEST dtoToEntity");
        final Parcel parcel = new Parcel()
                .weight(2.0f)
                .sender(new Recipient()
                                .name("Herbert")
                                .city("Vienna"))
                .recipient(new Recipient()
                        .name("Gustav")
                        .city("Berlin")
                );
        /*
        TrackingInformation trackingInformation = new TrackingInformation()
                .state(TrackingInformation.StateEnum.DELIVERED)
                .futureHops()
         */
        //ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        //assertEquals(parcelEntity.getId(), parcelEntity.getId());
    }

}
