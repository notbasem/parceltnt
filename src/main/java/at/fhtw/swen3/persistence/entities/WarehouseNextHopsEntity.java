package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_next_hops")
@Getter
@Setter
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column
    private Integer traveltimeMins;

    @ManyToOne
    @JoinColumn(name="fk_hop")
    private HopEntity hopEntity;

}
