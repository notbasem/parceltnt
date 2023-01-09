package at.fhtw.swen3.gps.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Resource implements Serializable {
    public String __type;
    public ArrayList<Double> bbox;
    public String name;
    public Point point;
    public Address address;
    public String confidence;
    public String entityType;
    public ArrayList<GeocodePoint> geocodePoints;
    public ArrayList<String> matchCodes;

    @Override
    public String toString() {
        return "Resource{" +
                "__type='" + __type + '\'' +
                ", bbox=" + bbox +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", address=" + address +
                ", confidence='" + confidence + '\'' +
                ", entityType='" + entityType + '\'' +
                ", geocodePoints=" + geocodePoints +
                ", matchCodes=" + matchCodes +
                '}';
    }
}
