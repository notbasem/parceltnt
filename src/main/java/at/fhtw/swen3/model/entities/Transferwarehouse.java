package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Transferwarehouse extends Hop {
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;
}
