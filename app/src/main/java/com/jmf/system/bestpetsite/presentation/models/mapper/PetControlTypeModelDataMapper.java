package com.jmf.system.bestpetsite.presentation.models.mapper;

import com.jmf.system.bestpetsite.domain.models.PetControlType;
import com.jmf.system.bestpetsite.presentation.models.PetControlTypeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class PetControlTypeModelDataMapper {

    public PetControlTypeModel transform(PetControlType petControlType){
        PetControlTypeModel petControlTypeModel=new PetControlTypeModel();
        petControlTypeModel.setId(petControlType.getId());
        petControlTypeModel.setPetId(petControlType.getPetId());
        petControlTypeModel.setDescription(petControlType.getDescription());
        petControlTypeModel.setStartDateAttention(petControlType.getStartDateAttention());
        petControlTypeModel.setAttentionHour(petControlType.getAttentionHour());
        petControlTypeModel.setControlType(petControlType.getControlType());
        petControlTypeModel.setFrequency(petControlType.getFrequency());
        petControlTypeModel.setNotes(petControlType.getNotes());
        return  petControlTypeModel;
    }

    public PetControlType transform(PetControlTypeModel petControlTypeModel){
        PetControlType petControlType=new PetControlType();
        petControlType.setId(petControlTypeModel.getId());
        petControlType.setPetId(petControlTypeModel.getPetId());
        petControlType.setDescription(petControlTypeModel.getDescription());
        petControlType.setStartDateAttention(petControlTypeModel.getStartDateAttention());
        petControlType.setAttentionHour(petControlTypeModel.getAttentionHour());
        petControlType.setControlType(petControlTypeModel.getControlType());
        petControlType.setFrequency(petControlTypeModel.getFrequency());
        petControlType.setNotes(petControlTypeModel.getNotes());
        return  petControlType;
    }

    public List<PetControlTypeModel> transform(List<PetControlType> petControlTypeList){
        List<PetControlTypeModel> petControlTypeModelList=new ArrayList<>();

        for (PetControlType petControlType: petControlTypeList) {
            petControlTypeModelList.add(transform(petControlType));
        }
        return  petControlTypeModelList;
    }
}
