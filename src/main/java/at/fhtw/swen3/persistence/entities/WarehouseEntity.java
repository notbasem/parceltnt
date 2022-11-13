package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
@Getter
@Setter
public class WarehouseEntity extends HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer level;
    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
