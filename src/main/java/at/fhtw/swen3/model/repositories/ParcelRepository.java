package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.Parcel;
import at.fhtw.swen3.model.entities.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    Parcel findByTrackingId(String trackingId);
    List<Parcel> findBySender(Recipient sender);
}
