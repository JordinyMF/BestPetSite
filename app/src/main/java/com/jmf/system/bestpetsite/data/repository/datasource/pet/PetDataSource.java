package com.jmf.system.bestpetsite.data.repository.datasource.pet;

import com.jmf.system.bestpetsite.data.entities.PetEntity;

import java.util.List;

/**
 * Created by JORDINY on 8/11/2017.
 */

public interface PetDataSource {
    List<PetEntity> getPetEntityList() throws Exception;

    PetEntity getPetEntity(PetEntity petEntity) throws Exception;

    PetEntity insertPetEntity(PetEntity petEntity) throws Exception;

    PetEntity updatePetEntity(PetEntity petEntity) throws Exception;

    PetEntity deletePetEntity(PetEntity petEntity) throws Exception;
}
