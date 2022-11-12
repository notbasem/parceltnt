package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {
    private final Validator validator;
    private final RecipientRepository recipientRepository;
    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(RecipientRepository recipientRepository, ParcelRepository parcelRepository, Validator validator) {
        this.validator = validator;
        this.recipientRepository = recipientRepository;
        this.parcelRepository = parcelRepository;
    }

    @Override
    public void submitNewParcel(ParcelEntity parcelEntity) {
        this.validator.validate(parcelEntity);
        this.recipientRepository.save(parcelEntity.getSender());
        this.recipientRepository.save(parcelEntity.getRecipient());
        this.parcelRepository.save(parcelEntity);
    }

    @Override
    public void updateParcel(String id, ParcelEntity parcelEntity) {
        this.parcelRepository.save(parcelEntity);
    }

    @Override
    public void deleteParcel(String id) {
        this.parcelRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public List<Parcel> getParcels() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = this.parcelRepository.findAll();
        for(ParcelEntity parcelEntity : parcelEntities) {
            parcelDtos.add(ParcelMapper.INSTANCE.entityToDto(parcelEntity));
        }
        return parcelDtos;
    }
}
