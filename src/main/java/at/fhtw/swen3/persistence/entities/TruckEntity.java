package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "truck")
public class TruckEntity extends HopEntity{
    @Lob
    private String regionGeoJson;
    private String numberPlate;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Truck {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    regionGeoJson: ").append(toIndentedString(regionGeoJson)).append("\n");
        sb.append("    numberPlate: ").append(toIndentedString(numberPlate)).append("\n");
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
