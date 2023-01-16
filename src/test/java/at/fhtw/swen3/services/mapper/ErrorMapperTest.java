package at.fhtw.swen3.services.mapper;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ErrorMapperTest {

    @Test
    public void testDtoToEntity() {
        // Create a Error DTO object
        Error errorDto = new Error();
        errorDto.setErrorMessage("This is an error message.");

        // Use the ErrorMapper to convert the DTO to an entities
        ErrorEntity errorEntity = ErrorMapper.INSTANCE.dtoToEntity(errorDto);

        // Assert that the values of the DTO and entities match
        assertEquals(errorDto.getErrorMessage(), errorEntity.getErrorMessage());
    }
    @Test
    public void testEntityToDto() {
        // Create a ErrorEntity object
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setErrorMessage("This is an error message.");

        // Use the ErrorMapper to convert the entities to dto
        Error errorDto = ErrorMapper.INSTANCE.entityToDto(errorEntity);

        // Assert that the values of the DTO and entities match
        assertEquals(errorEntity.getErrorMessage(), errorDto.getErrorMessage());
    }

}




