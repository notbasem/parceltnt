package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_next_hops")
@Getter
@Setter
@ToString
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column
    private Integer traveltimeMins;

    @OneToOne
    private HopEntity hopEntity;
}
