package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class TruckEntity extends HopEntity{
    private String regionGeoJson;
    private String numberPlate;
}
