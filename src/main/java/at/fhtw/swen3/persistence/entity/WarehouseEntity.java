package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WarehouseEntity extends HopEntity {
    private Integer level;
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
