package at.fhtw.swen3.services.mapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;


public class GeoCoordinateMapperTest{
    private final GeoCoordinateMapper mapper = GeoCoordinateMapper.INSTANCE;

    @Test
    public void testDtoToEntity() {
        GeoCoordinate dto = new GeoCoordinate();
        dto.setLat(48.210033);
        dto.setLon(16.363449);

        GeoCoordinateEntity entity = mapper.dtoToEntity(dto);

        assertEquals(dto.getLat(), entity.getLat(), 0.0001);
        assertEquals(dto.getLon(), entity.getLon(), 0.0001);
    }

    @Test
    public void testEntityToDto() {
        GeoCoordinateEntity entity = new GeoCoordinateEntity();
        entity.setLat(48.210033);
        entity.setLon(16.363449);

        GeoCoordinate dto = mapper.entityToDto(entity);

        assertEquals(entity.getLat(), dto.getLat(), 0.0001);
        assertEquals(entity.getLon(), dto.getLon(), 0.0001);
    }
}
