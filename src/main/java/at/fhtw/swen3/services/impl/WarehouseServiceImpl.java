package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    private final Validator validator;
    private final WarehouseRepository warehouseRepository;
    private final GeoCoordinateRepository geoCoordinateRepository;
    private final TruckRepository truckRepository;
    private final TransferwarehouseRepository transferwarehouseRepository;
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;

    @Override
    public List<Warehouse> getWarehouse() {
        log.info("getWarehouse()");


        return null;
    }

    @Override
    public void importWarehouses(WarehouseEntity warehouseEntity) {
        log.info("importWarehouses()");
        this.validator.validate(warehouseEntity);

        if (warehouseRepository.findAll().isEmpty()) {
            /**
             *  TODO: Delete all Warehouses, WarehouseNextHops, Trucks, Transferwarehouses
             */
        }

        System.out.println(warehouseEntity);

        saveHopsRecursive(warehouseEntity.getNextHops());
        geoCoordinateRepository.save(warehouseEntity.getLocationCoordinates());
        warehouseRepository.save(warehouseEntity);
    }

    private void saveHopsRecursive(List<WarehouseNextHopsEntity> nextHops) {
        for (WarehouseNextHopsEntity nextHop : nextHops) {
            geoCoordinateRepository.save(nextHop.getHop().getLocationCoordinates());
            switch (nextHop.getHop().getHopType()) {
                case "warehouse" -> saveHopsRecursive(((WarehouseEntity) nextHop.getHop()).getNextHops());
                case "truck" -> truckRepository.save((TruckEntity) nextHop.getHop());
                case "transferwarehouse" -> transferwarehouseRepository.save((TransferwarehouseEntity) nextHop.getHop());
            }
            warehouseNextHopsRepository.save(nextHop);
        }
    }

    @Override
    public void exportWarehouse() {
        log.info("exportWarehouse()");
    }
}
