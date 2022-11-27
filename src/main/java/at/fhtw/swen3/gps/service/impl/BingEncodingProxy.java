package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.dto.GeoCoordinateREST;
import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class BingEncodingProxy implements GeoEncodingService {
    private final String url = "http://dev.virtualearth.net/REST/v1/Locations?" +
            "key=Api4dLTpYSaEsX16Tp83I4j3-3c--Fb87q_XK6scozoBj0tYNBLTpIAU-z6G83Bo" +
            "&addressLine={addressline}";
    private final RestTemplate restTemplate;


    public BingEncodingProxy(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public GeoCoordinateEntity encodeAddress(String address) {
        GeoCoordinateREST geoCoordinate = this.restTemplate.getForObject(url, GeoCoordinateREST.class, address);
        if (geoCoordinate != null) {
            Object resourceSet = geoCoordinate.resourceSets.get(0);
            System.out.println(resourceSet);
        }
        return new GeoCoordinateEntity();
    }
}