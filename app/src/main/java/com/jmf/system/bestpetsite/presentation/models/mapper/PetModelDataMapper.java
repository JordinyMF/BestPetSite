package com.jmf.system.bestpetsite.presentation.models.mapper;

import com.jmf.system.bestpetsite.domain.models.Pet;
import com.jmf.system.bestpetsite.presentation.models.PetModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 18/11/2017.
 */

public class PetModelDataMapper {

    public PetModel transform(Pet pet){
        PetModel petModel=new PetModel();
        petModel.setId(pet.getId());
        petModel.setName(pet.getName());
        petModel.setAge(pet.getAge());
        petModel.setRace(pet.getRace());
        petModel.setColor(pet.getColor());
        petModel.setPhoto(pet.getPhoto());
        return  petModel;
    }

    public Pet transform(PetModel petModel){
        Pet pet=new Pet();
        pet.setId(petModel.getId());
        pet.setName(petModel.getName());
        pet.setAge(petModel.getAge());
        pet.setRace(petModel.getRace());
        pet.setColor(petModel.getColor());
        pet.setPhoto(petModel.getPhoto());
        return  pet;
    }

    public List<PetModel> transform(List<Pet> petList){
        List<PetModel> petModelList=new ArrayList<>();

        for (Pet pet: petList) {
            petModelList.add(transform(pet));
        }
        return  petModelList;
    }
}
