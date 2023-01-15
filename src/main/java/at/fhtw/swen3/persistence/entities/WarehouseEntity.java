package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseEntity extends HopEntity {
    private Integer level;

    @Column
    @NotNull
    @NotEmpty(message = "nextHops cannot be null")
    @OneToMany(fetch = FetchType.EAGER)
    private List<WarehouseNextHopsEntity> nextHops;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Warehouse {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    nextHops: ").append(toIndentedString(nextHops)).append("\n");
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
