package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity(name = "hop")
@Getter
@Setter
public class HopEntity {
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
    private GeoCoordinateEntity locationCoordinates;


}
