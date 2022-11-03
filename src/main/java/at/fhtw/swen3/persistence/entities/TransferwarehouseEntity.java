package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class TransferwarehouseEntity extends HopEntity{
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;
}
