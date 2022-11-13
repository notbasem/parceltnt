package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ParcelRepositoryTest {
    @Autowired
    private ParcelRepository parcelRepository;
    private static ParcelEntity parcelEntity;

    @BeforeAll
    static void setUp() {
        parcelEntity = new ParcelEntity()
                .weight(2.0f)
                .sender(new RecipientEntity()
                        .name("Herbert")
                        .city("Vienna"))
                .recipient(new RecipientEntity()
                        .name("Gustav")
                        .city("Berlin")
                );
    }

    @Test
    public void saveParcelEntityTrue() {
        ParcelEntity parcel = parcelRepository.save(parcelEntity);
        assertEquals(parcel.getWeight(), parcelEntity.getWeight());
        assertEquals(parcel.getSender(), parcelEntity.getSender());
        assertEquals(parcel.getRecipient(), parcelEntity.getRecipient());
    }
}
