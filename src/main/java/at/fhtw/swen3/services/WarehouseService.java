package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;

public interface WarehouseService {
    public abstract Hop getWarehouse(String code);
    public abstract void importWarehouses(WarehouseEntity warehouseEntity);
    public abstract Warehouse exportWarehouses();
}
