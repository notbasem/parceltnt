package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;

import java.util.List;

public interface WarehouseService {
    public abstract List<Warehouse> getWarehouse();
    public abstract void importWarehouses(WarehouseEntity warehouseEntity);
    public abstract Warehouse exportWarehouses();
}
