package at.fhtw.swen3.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "parcel")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private float weight;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private Recipient recipient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Recipient sender;

    @Column
    private String trackingId;

    @Column
    private Enum state;

    public Parcel(Long id, float weight) {
        this.id = id;
        this.weight = weight;
    }

    /*
    private List<HopArrival> visitedHops = new ArrayList<>();
    private List<HopArrival> futureHops = new ArrayList<>();
     */
}
