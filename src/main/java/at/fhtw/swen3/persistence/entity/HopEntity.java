package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//@Entity(name = "hop")
@Getter
@Setter
public class HopEntity {
    private String hopType;
    @Pattern(regexp = "^[A-Za-zÄÖÜäöüß0-9\\s\\-]+$")
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    @NotNull
    private GeoCoordinateEntity locationCoordinates;


}
