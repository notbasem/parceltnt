package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GeoCoordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //@Type(type="org.hibernate.spatial.GeometryType")
    //private Point location;

    private Double lat;
    private Double lon;
}
