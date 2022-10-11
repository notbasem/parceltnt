package at.fhtw.swen3.services.dto;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.TrackingInformation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TrackingInformationDto {
    private TrackingInformation.StateEnum state;
    private List<HopArrival> visitedHops = new ArrayList<>();
    private List<HopArrival> futureHops = new ArrayList<>();
}
