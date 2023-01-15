package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.NewParcelInfoMapper;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.TrackingInformationMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Slf4j
public class ParcelServiceImpl implements ParcelService {
    private final Validator validator;
    private final RecipientRepository recipientRepository;
    private final ParcelRepository parcelRepository;

    @Override
    public NewParcelInfo submitNewParcel(ParcelEntity parcelEntity) {
        log.info("submitNewParcel() with parcel: " + parcelEntity);
        this.validator.validate(parcelEntity);
        parcelEntity.setTrackingId(generateTrackingId());
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);

        GeoCoordinateEntity geoCoordinateSender = new BingEncodingProxy().encodeAddress(parcelEntity.getSender().getStreet() + ", " + parcelEntity.getSender().getPostalCode() + " " + parcelEntity.getSender().getCity() + ", " + parcelEntity.getSender().getCountry());
        System.out.println(geoCoordinateSender.getLat() + " : " + geoCoordinateSender.getLon());

        GeoCoordinateEntity geoCoordinateRecipient = new BingEncodingProxy().encodeAddress(parcelEntity.getRecipient().getStreet() + ", " + parcelEntity.getRecipient().getPostalCode() + " " + parcelEntity.getRecipient().getCity() + ", " + parcelEntity.getRecipient().getCountry());
        System.out.println(geoCoordinateRecipient.getLat() + " : " + geoCoordinateRecipient.getLon());

        this.recipientRepository.save(parcelEntity.getSender());
        this.recipientRepository.save(parcelEntity.getRecipient());
        this.parcelRepository.save(parcelEntity);
        return NewParcelInfoMapper.INSTANCE.entityToDto(parcelEntity);
    }

    @Override
    public TrackingInformation getParcelByTrackingId(String trackingId) {
        log.info("getParcelByTrackingId() with trackingId: " + trackingId);
        ParcelEntity parcelEntity = this.parcelRepository.findByTrackingId(trackingId);
        return TrackingInformationMapper.INSTANCE.entityToDto(parcelEntity);
    }

    @Override
    public void updateParcel(String id, ParcelEntity parcelEntity) {
        log.info("updateParcel() with id=" + id + " , parcel: " + parcelEntity);
        this.parcelRepository.save(parcelEntity);
    }

    @Override
    public void deleteParcel(String id) {
        log.info("deleteParcel() with id=" + id);
        this.parcelRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public List<Parcel> getParcels() {
        log.info("getParcels()");
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = this.parcelRepository.findAll();
        for(ParcelEntity parcelEntity : parcelEntities) {
            parcelDtos.add(ParcelMapper.INSTANCE.entityToDto(parcelEntity));
        }
        return parcelDtos;
    }

    @Override
    public void reportParcelDelivery(String trackingId) {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);
        if (parcelEntity == null) {
            log.error("Parcel with given trackingId: " + trackingId + " not found");
            return;
        }
        parcelEntity.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(parcelEntity);
    }

    @Override
    public NewParcelInfo transitionParcel(String trackingId, ParcelEntity parcelEntity) {
        log.info("transitionParcel() with trackingId: " + trackingId + " and parcel: " + parcelEntity);
        this.validator.validate(parcelEntity);
        parcelEntity.setTrackingId(trackingId);
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);

        GeoCoordinateEntity geoCoordinateSender = new BingEncodingProxy().encodeAddress(parcelEntity.getSender().getStreet() + ", " + parcelEntity.getSender().getPostalCode() + " " + parcelEntity.getSender().getCity() + ", " + parcelEntity.getSender().getCountry());
        System.out.println(geoCoordinateSender.getLat() + " : " + geoCoordinateSender.getLon());

        GeoCoordinateEntity geoCoordinateRecipient = new BingEncodingProxy().encodeAddress(parcelEntity.getRecipient().getStreet() + ", " + parcelEntity.getRecipient().getPostalCode() + " " + parcelEntity.getRecipient().getCity() + ", " + parcelEntity.getRecipient().getCountry());
        System.out.println(geoCoordinateRecipient.getLat() + " : " + geoCoordinateRecipient.getLon());

        this.recipientRepository.save(parcelEntity.getSender());
        this.recipientRepository.save(parcelEntity.getRecipient());
        this.parcelRepository.save(parcelEntity);
        return NewParcelInfoMapper.INSTANCE.entityToDto(parcelEntity);
    }

    @Override
    public void reportParcelHop(String trackingId, String code) {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);

    }

    private String generateTrackingId() {
        String allowedchars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        for (int i=0; i<9; i++) {
            Random random = new Random();
            result.append(allowedchars.charAt(random.nextInt(allowedchars.length())));
        }
        return result.toString();
    }
}
