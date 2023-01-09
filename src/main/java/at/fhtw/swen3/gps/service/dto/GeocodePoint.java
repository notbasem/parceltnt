package at.fhtw.swen3.gps.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class GeocodePoint implements Serializable {
    public String type;
    public ArrayList<Double> coordinates;
    public String calculationMethod;
    public ArrayList<String> usageTypes;
}
