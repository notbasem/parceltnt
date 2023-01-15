package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
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
    public Hop getWarehouse(String code) {
        log.info("getWarehouse()");
        HopEntity hopEntity = null;

        if (truckRepository.findByCode(code) != null) {
            hopEntity = truckRepository.findByCode(code);
        } else if (transferwarehouseRepository.findByCode(code) != null) {
            hopEntity = transferwarehouseRepository.findByCode(code);
        } else if(warehouseRepository.findByCode(code) != null) {
            hopEntity = warehouseRepository.findByCode(code);
        }

        return HopMapper.INSTANCE.entityToDto(hopEntity);
    }

    @Override
    public void importWarehouses(WarehouseEntity warehouseEntity) {
        log.info("importWarehouses()");
        this.validator.validate(warehouseEntity);

        if (!warehouseRepository.findAll().isEmpty()) {
            warehouseRepository.deleteAll();
            warehouseNextHopsRepository.deleteAll();
            transferwarehouseRepository.deleteAll();
            truckRepository.deleteAll();
        }

        saveHopsRecursive(warehouseEntity.getNextHops());
        geoCoordinateRepository.save(warehouseEntity.getLocationCoordinates());
        warehouseRepository.save(warehouseEntity);
    }

    @Override
    public Warehouse exportWarehouses() {
        WarehouseEntity warehouseEntity = warehouseRepository.findByLevel(0);
        System.out.println(warehouseEntity);
        return WarehouseMapper.INSTANCE.entityToDto(warehouseEntity);
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
}
