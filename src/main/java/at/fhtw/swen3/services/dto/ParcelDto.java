package at.fhtw.swen3.services.dto;

import at.fhtw.swen3.persistence.NewParcelInfo;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.TrackingInformation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ParcelDto {
    private Long id;
    private float weight;
    private Recipient recipient;
    private Recipient sender;
}
