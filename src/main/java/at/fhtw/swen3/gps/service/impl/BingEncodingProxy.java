package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.dto.GeoCoordinateREST;
import at.fhtw.swen3.gps.service.dto.*;
import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class BingEncodingProxy implements GeoEncodingService {
    private String url = "http://dev.virtualearth.net/REST/v1/Locations?" +
            "key=Api4dLTpYSaEsX16Tp83I4j3-3c--Fb87q_XK6scozoBj0tYNBLTpIAU-z6G83Bo" +
            "&addressLine={addressline}";


    public BingEncodingProxy() {
    }

    @Override
    public GeoCoordinateEntity encodeAddress(String address) {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        url = url.replace("{addressline}", address);
        RestTemplate restTemplate = new RestTemplate();
        GeoCoordinateREST geoCoordinate = restTemplate.getForObject(url, GeoCoordinateREST.class);
        if (geoCoordinate != null) {
            ResourceSet resourceSet = geoCoordinate.resourceSets.get(0);
            Resource resource = resourceSet.resources.get(0);
            // Get the point
            Point point = resource.point;
            geoCoordinateEntity.setLat(point.getLatitude());
            geoCoordinateEntity.setLon(point.getLongitude());
        }
        return geoCoordinateEntity;
    }
}
