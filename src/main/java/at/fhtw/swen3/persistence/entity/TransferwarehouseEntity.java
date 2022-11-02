package at.fhtw.swen3.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

//@Entity(name = "transferwarehouse")
@Getter
@Setter
public class TransferwarehouseEntity extends HopEntity{
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;
}
