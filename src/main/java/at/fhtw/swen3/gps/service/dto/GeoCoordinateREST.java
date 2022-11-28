package at.fhtw.swen3.gps.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class Address implements Serializable {
    public String addressLine;
    public String adminDistrict;
    public String adminDistrict2;
    public String countryRegion;
    public String formattedAddress;
    public String locality;
    public String postalCode;
}

class GeocodePoint implements Serializable{
    public String type;
    public ArrayList<Double> coordinates;
    public String calculationMethod;
    public ArrayList<String> usageTypes;
}

class Point implements Serializable{
    public String type;
    public ArrayList<Double> coordinates;
}

class Resource implements Serializable{
    public String __type;
    public ArrayList<Double> bbox;
    public String name;
    public Point point;
    public Address address;
    public String confidence;
    public String entityType;
    public ArrayList<GeocodePoint> geocodePoints;
    public ArrayList<String> matchCodes;
}

class ResourceSet{
    public int estimatedTotal;
    public ArrayList<Resource> resources;
}

public class GeoCoordinateREST implements Serializable{
    public String authenticationResultCode;
    public String brandLogoUri;
    public String copyright;
    public ArrayList<ResourceSet> resourceSets;
    public int statusCode;
    public String statusDescription;
    public String traceId;
}
