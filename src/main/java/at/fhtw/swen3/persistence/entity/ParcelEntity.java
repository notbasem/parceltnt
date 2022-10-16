package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    private float weight;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private RecipientEntity recipient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private RecipientEntity sender;
    private String trackingId;
    private Enum state;

    @OneToMany(mappedBy="fk_parcel")
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();
    @OneToMany(mappedBy="fk_parcel")
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    public ParcelEntity(Long id, float weight) {
        this.id = id;
        this.weight = weight;
    }
}
