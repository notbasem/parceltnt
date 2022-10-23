package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

//@Entity(name = "parcel")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParcelEntity {
    @DecimalMin(value = "0.0", message = "Minimum weight should be greater than 0.0")
    private float weight;
    private RecipientEntity recipient;
    private RecipientEntity sender;
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
    private TrackingInformation.StateEnum state;
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    /**
     * Constructor-like functionality to build an Object
     */
    public ParcelEntity weight(Float weight) {
        this.weight = weight;
        return this;
    }

    public ParcelEntity recipient(RecipientEntity recipientEntity) {
        this.recipient = recipientEntity;
        return this;
    }

    public ParcelEntity sender(RecipientEntity recipientEntity) {
        this.sender = recipientEntity;
        return this;
    }

    public ParcelEntity trackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public ParcelEntity state(TrackingInformation.StateEnum state) {
        this.state = state;
        return this;
    }
}
