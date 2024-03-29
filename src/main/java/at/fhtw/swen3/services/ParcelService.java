package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import java.util.List;

public interface ParcelService {
    public abstract NewParcelInfo submitNewParcel(ParcelEntity parcelEntity);
    public abstract TrackingInformation getParcelByTrackingId(String trackingId);
    public abstract void updateParcel(String id, ParcelEntity parcelEntity);
    public abstract void deleteParcel(String id);
    public abstract List<Parcel> getParcels();

    void reportParcelDelivery(String trackingId);

    NewParcelInfo transitionParcel(String trackingId, ParcelEntity parcelEntity);

    void reportParcelHop(String trackingId, String code);
}
