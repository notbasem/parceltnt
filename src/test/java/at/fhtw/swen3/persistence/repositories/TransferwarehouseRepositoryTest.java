package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TransferwarehouseRepositoryTest {

    @Autowired
    private TransferwarehouseRepository transferwarehouseRepository;

    @Test
    void testFindById() {
        // given
        TransferwarehouseEntity transferwarehouse = new TransferwarehouseEntity();
        transferwarehouse.setRegionGeoJson("Test region");
        transferwarehouse.setLogisticsPartner("Test logistics partner");
        transferwarehouse.setLogisticsPartnerUrl("Test logistics partner url");
        transferwarehouse = transferwarehouseRepository.save(transferwarehouse);

        // when
        Optional<TransferwarehouseEntity> foundTransferwarehouse = transferwarehouseRepository.findById(transferwarehouse.getId());

        // then
        assertTrue(foundTransferwarehouse.isPresent());
        assertEquals(transferwarehouse.getRegionGeoJson(), foundTransferwarehouse.get().getRegionGeoJson());
        assertEquals(transferwarehouse.getLogisticsPartner(), foundTransferwarehouse.get().getLogisticsPartner());
        assertEquals(transferwarehouse.getLogisticsPartnerUrl(), foundTransferwarehouse.get().getLogisticsPartnerUrl());
    }
}

