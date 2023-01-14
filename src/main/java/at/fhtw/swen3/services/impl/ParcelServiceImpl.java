package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
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
        GeoCoordinateEntity geoCoordinateEntity = new BingEncodingProxy().encodeAddress(parcelEntity.getSender().getStreet() + ", " + parcelEntity.getSender().getPostalCode() + " " + parcelEntity.getSender().getCity() + ", " + parcelEntity.getSender().getCountry());
        System.out.println(geoCoordinateEntity.getLat() + " : " + geoCoordinateEntity.getLon());

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
