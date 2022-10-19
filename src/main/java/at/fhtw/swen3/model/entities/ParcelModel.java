package at.fhtw.swen3.model.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "parcel")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParcelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @DecimalMin(value = "0.0", message = "Minimum weight should be greater than 0.0")
    private float weight;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    @NotNull(message = "Recipient cannot be null.")
    private RecipientModel recipient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    @NotNull(message = "Sender cannot be null.")
    private RecipientModel sender;
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy="fk_parcel")
    @NotNull(message = "Visited Hops cannot be null.")
    private List<HopArrivalModel> visitedHops = new ArrayList<>();
    @OneToMany(mappedBy="fk_parcel")
    @NotNull(message = "Future hops cannot be null.")
    private List<HopArrivalModel> futureHops = new ArrayList<>();

    /**
     * Constructor-like functionality to build an Object
     */
    public ParcelModel weight(Float weight) {
        this.weight = weight;
        return this;
    }

    public ParcelModel recipient(RecipientModel recipientModel) {
        this.recipient = recipientModel;
        return this;
    }

    public ParcelModel sender(RecipientModel recipientModel) {
        this.sender = recipientModel;
        return this;
    }

    public ParcelModel trackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public ParcelModel state(TrackingInformation.StateEnum state) {
        this.state = state;
        return this;
    }
}
