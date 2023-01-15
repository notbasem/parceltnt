package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
public class WarehouseEntity extends HopEntity {
    private Integer level;

    @Column
    @NotNull
    @NotEmpty(message = "nextHops cannot be null")
    @OneToMany(mappedBy="hopEntity", fetch= FetchType.EAGER)
    private List<WarehouseNextHopsEntity> nextHops;
}
