package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;

import java.util.List;

public interface ParcelService {
    public abstract void submitNewParcel(Parcel parcel);
    public abstract void updateParcel(String id, Parcel parcel);
    public abstract void deleteParcel(String id);
    public abstract List<Parcel> getParcels();
}
