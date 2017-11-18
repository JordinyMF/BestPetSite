package com.jmf.system.bestpetsite.data.entities.mapper;

import com.jmf.system.bestpetsite.data.entities.PetEntity;
import com.jmf.system.bestpetsite.domain.models.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 18/11/2017.
 */

public class PetEntityDataMapper {

    public Pet transform(PetEntity petEntity){
        Pet pet=new Pet();
        pet.setId(petEntity.getId());
        pet.setName(petEntity.getName());
        pet.setAge(petEntity.getAge());
        pet.setRace(petEntity.getRace());
        pet.setColor(petEntity.getColor());
        return  pet;
    }

    public PetEntity transform(Pet pet){
        PetEntity petEntity=new PetEntity();
        petEntity.setId(pet.getId());
        petEntity.setName(pet.getName());
        petEntity.setAge(pet.getAge());
        petEntity.setRace(pet.getRace());
        petEntity.setColor(pet.getColor());
        petEntity.setStatus(true);
        return  petEntity;
    }

  public    List<Pet> transform(List<PetEntity> petEntityList){
        List<Pet> petList=new ArrayList<>();

        for (PetEntity petEntity: petEntityList) {
            petList.add(transform(petEntity));
        }
        return  petList;
    }
}
