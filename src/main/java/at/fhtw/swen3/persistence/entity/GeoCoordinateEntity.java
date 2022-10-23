package at.fhtw.swen3.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity(name = "geo_coordinate")
@Getter
@Setter
public class GeoCoordinateEntity {
    private Double lat;
    private Double lon;
}
