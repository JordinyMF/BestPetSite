package com.jmf.system.bestpetsite.data.network.interfaces;

import com.jmf.system.bestpetsite.data.entities.CustomerEntity;
import com.jmf.system.bestpetsite.data.entities.PetEntity;
import com.jmf.system.bestpetsite.data.entities.UserEntity;

import java.util.List;

/**
 * Created by JORDINY on 8/11/2017.
 */

public interface PetDataStore {

    List<PetEntity> getPetEntityList() throws Exception;

    PetEntity getPetEntity(PetEntity petEntity) throws Exception;

    PetEntity insertPetEntity(PetEntity petEntity) throws Exception;

    PetEntity updatePetEntity(PetEntity petEntity) throws Exception;

    PetEntity deletePetEntity(PetEntity petEntity) throws Exception;
}
