package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "warehousenext_hops")
@Getter
@Setter
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column
    private Integer traveltimeMins;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hop_id")
    private HopEntity hop;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WarehouseAllOfNextHops {\n");
        sb.append("    traveltimeMins: ").append(toIndentedString(traveltimeMins)).append("\n");
        sb.append("    hop: ").append(toIndentedString(hop)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
