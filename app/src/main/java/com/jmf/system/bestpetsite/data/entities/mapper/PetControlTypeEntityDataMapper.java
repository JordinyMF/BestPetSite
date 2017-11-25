package com.jmf.system.bestpetsite.data.entities.mapper;

import com.jmf.system.bestpetsite.data.entities.PetControlTypeEntity;
import com.jmf.system.bestpetsite.domain.models.PetControlType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class PetControlTypeEntityDataMapper {
    public PetControlType transform(PetControlTypeEntity petControlTypeEntity){
        PetControlType petControlType=new PetControlType();
        petControlType.setId(petControlTypeEntity.getId());
        petControlType.setPetId(petControlTypeEntity.getPetId());
        petControlType.setDescription(petControlTypeEntity.getDescription());
        petControlType.setStartDateAttention(petControlTypeEntity.getStartDateAttention());
        petControlType.setAttentionHour(petControlTypeEntity.getAttentionHour());
        petControlType.setControlType(petControlTypeEntity.getControlType());
        petControlType.setFrequency(petControlTypeEntity.getFrequency());
        petControlType.setNotes(petControlTypeEntity.getNotes());
        return  petControlType;
    }

    public PetControlTypeEntity transform(PetControlType petControlType){
        PetControlTypeEntity petControlTypeEntity=new PetControlTypeEntity();
        petControlTypeEntity.setId(petControlType.getId());
        petControlTypeEntity.setPetId(petControlType.getPetId());
        petControlTypeEntity.setDescription(petControlType.getDescription());
        petControlTypeEntity.setStartDateAttention(petControlType.getStartDateAttention());
        petControlTypeEntity.setAttentionHour(petControlType.getAttentionHour());
        petControlTypeEntity.setControlType(petControlType.getControlType());
        petControlTypeEntity.setFrequency(petControlType.getFrequency());
        petControlTypeEntity.setNotes(petControlType.getNotes());
        return  petControlTypeEntity;
    }

    public List<PetControlType> transform(List<PetControlTypeEntity> petEntityList){
        List<PetControlType> petControlTypeList=new ArrayList<>();

        for (PetControlTypeEntity petControlTypeEntity: petEntityList) {
            petControlTypeList.add(transform(petControlTypeEntity));
        }
        return  petControlTypeList;
    }
}
