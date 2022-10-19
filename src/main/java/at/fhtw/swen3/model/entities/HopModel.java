package at.fhtw.swen3.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity(name = "hop")
@Getter
@Setter
public class HopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String hopType;
    private String code;
    @Pattern(regexp = "^[A-Za-zÄÖÜäöüß0-9\\s\\-]+$")
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    @OneToOne
    @JoinColumn(name = "location_coordinate_id")
    private GeoCoordinateModel locationCoordinates;


}
