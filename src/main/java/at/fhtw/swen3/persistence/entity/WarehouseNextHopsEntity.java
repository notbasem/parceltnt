package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.Hop;
import lombok.Getter;
import lombok.Setter;

//@Entity(name = "warehouse_next_hops")
@Getter
@Setter

public class WarehouseNextHopsEntity {
    private Integer traveltimeMins;
    private Hop hop;
}
