package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "transferwarehouse")
@Getter
@Setter
public class TransferwarehouseEntity extends HopEntity{
    @Column(columnDefinition = "text")
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transferwarehouse {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    regionGeoJson: ").append(toIndentedString(regionGeoJson)).append("\n");
        sb.append("    logisticsPartner: ").append(toIndentedString(logisticsPartner)).append("\n");
        sb.append("    logisticsPartnerUrl: ").append(toIndentedString(logisticsPartnerUrl)).append("\n");
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
