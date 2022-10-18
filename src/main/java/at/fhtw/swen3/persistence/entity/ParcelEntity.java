package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "parcel")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(min = 0)
    private float weight;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    @NotNull
    private RecipientEntity recipient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    @NotNull
    private RecipientEntity sender;
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
    private TrackingInformation.StateEnum state;

    @OneToMany(mappedBy="fk_parcel")
    @NotNull
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();
    @OneToMany(mappedBy="fk_parcel")
    @NotNull
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
