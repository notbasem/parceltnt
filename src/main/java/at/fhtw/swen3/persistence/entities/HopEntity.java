package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "hop")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String hopType;
    @Pattern(regexp = "^[A-Za-zÄÖÜäöüß0-9\\s\\-]+$")
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "GeoCoordinates cannot be null")
    private GeoCoordinateEntity locationCoordinates;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Hop {\n");
        sb.append("    hopType: ").append(toIndentedString(hopType)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    processingDelayMins: ").append(toIndentedString(processingDelayMins)).append("\n");
        sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
        sb.append("    locationCoordinates: ").append(toIndentedString(locationCoordinates)).append("\n");
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
