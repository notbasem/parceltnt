package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-18T11:33:06+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class ErrorMapperImpl implements ErrorMapper {

    @Override
    public ErrorEntity dtoToEntity(Error error) {
        if ( error == null ) {
            return null;
        }

        ErrorEntity errorEntity = new ErrorEntity();

        return errorEntity;
    }

    @Override
    public Error entityToDto(ErrorEntity errorEntity) {
        if ( errorEntity == null ) {
            return null;
        }

        Error error = new Error();

        return error;
    }
}
