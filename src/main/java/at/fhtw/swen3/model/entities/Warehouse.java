package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Warehouse extends Hop {
    private Integer level;
    @OneToMany
    private List<WarehouseNextHops> nextHops = new ArrayList<>();
}
