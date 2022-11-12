package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    private final Validator validator;
    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(Validator validator, WarehouseRepository warehouseRepository) {
        this.validator = validator;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getWarehouse() {
        return null;
    }

    @Override
    public void importWarehouses() {

    }

    @Override
    public void exportWarehouse() {

    }
}