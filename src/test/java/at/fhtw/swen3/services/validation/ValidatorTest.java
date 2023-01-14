package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.validation.Validator;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    public void testValidate_validParcelEntity_noException() {
        RecipientEntity recipient = new RecipientEntity()
                .name("John Doe")
                .street("Street 1/2")
                .postalCode("A-1234")
                .city("City")
                .country("Country");
        RecipientEntity sender = new RecipientEntity()
                .name("Jane Doe")
                .street("Street 2/2")
                .postalCode("A-1234")
                .city("City")
                .country("Country");
        ParcelEntity validParcelEntity = new ParcelEntity()
                .weight(5.5f)
                .recipient(recipient)
                .sender(sender)
                .trackingId("ABC123456")
                .state(TrackingInformation.StateEnum.PICKUP);
        validator.validate(validParcelEntity);

    }

    @Test
    public void testValidate_invalidParcelEntity_throwsException() {
        assertThrows(ConstraintViolationException.class, () -> {
            RecipientEntity recipient = new RecipientEntity()
                    .name("John")
                    .street("Street")
                    .postalCode("A-123")
                    .city("City")
                    .country("Country");
            RecipientEntity sender = new RecipientEntity()
                    .name("Jane")
                    .street("Street")
                    .postalCode("A-123")
                    .city("City")
                    .country("Country");
            ParcelEntity invalidParcelEntity = new ParcelEntity()
                    .weight(-5.5f)
                    .recipient(recipient)
                    .sender(sender)
                    .trackingId("ABC12345")
                    .state(TrackingInformation.StateEnum.PICKUP);
            validator.validate(invalidParcelEntity);
        });
    }
}