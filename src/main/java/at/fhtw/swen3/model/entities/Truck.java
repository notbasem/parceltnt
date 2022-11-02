package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Truck extends Hop {
    private String regionGeoJson;
    private String numberPlate;
}
