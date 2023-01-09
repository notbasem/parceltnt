package at.fhtw.swen3.gps.service.dto;

import java.io.Serializable;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Address implements Serializable {
    public String addressLine;
    public String adminDistrict;
    public String adminDistrict2;
    public String countryRegion;
    public String formattedAddress;
    public String locality;
    public String postalCode;
}
