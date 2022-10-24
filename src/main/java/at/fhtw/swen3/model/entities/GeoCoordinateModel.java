package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity(name = "geo_coordinate")
@Getter
@Setter
public class GeoCoordinateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //@Type(type="org.hibernate.spatial.GeometryType")
    //private Point location;

    private Double lat;
    private Double lon;
}
