package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipientRepositoryTest {
    @Autowired
    private RecipientRepository recipientRepository;
    private static RecipientEntity recipientEntity;

    @BeforeAll
    static void setUp() {
        recipientEntity = new RecipientEntity()
                .name("Max")
                .street("Carabelligasse 12")
                .postalCode("A-1210")
                .city("Vienna")
                .country("Austria");
    }

    @Test
    public void saveRecipientEntityTrue() {
        RecipientEntity recipient = recipientRepository.save(recipientEntity);
        assertEquals(recipient.getName(), recipientEntity.getName());
        assertEquals(recipient.getStreet(), recipientEntity.getStreet());
        assertEquals(recipient.getPostalCode(), recipientEntity.getPostalCode());
        assertEquals(recipient.getCity(), recipientEntity.getCity());
        assertEquals(recipient.getCountry(), recipientEntity.getCountry());
    }
}
