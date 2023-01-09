package at.fhtw.swen3.gps.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class GeoCoordinateREST implements Serializable{
    public String authenticationResultCode;
    public String brandLogoUri;
    public String copyright;
    public ArrayList<ResourceSet> resourceSets;
    public int statusCode;
    public String statusDescription;
    public String traceId;
}
