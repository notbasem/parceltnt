package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.ParcelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelModel, Long> {
    ParcelModel findByTrackingId(String trackingId);
}
