package at.fhtw.swen3.model.repositories;

import at.fhtw.swen3.model.entities.WarehouseNextHops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHops, Long> {
}
