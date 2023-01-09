package at.fhtw.swen3.gps.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Point implements Serializable {
    public String type;
    public ArrayList<Double> coordinates;

    public double getLongitude() {
        return coordinates.get(1);
    }

    public double getLatitude() {
        return coordinates.get(0);
    }
}
