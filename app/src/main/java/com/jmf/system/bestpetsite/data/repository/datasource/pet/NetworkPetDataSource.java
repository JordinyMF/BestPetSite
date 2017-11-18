package com.jmf.system.bestpetsite.data.repository.datasource.pet;

import com.jmf.system.bestpetsite.data.entities.PetEntity;
import com.jmf.system.bestpetsite.data.network.implementations.RestPetDataStore;
import com.jmf.system.bestpetsite.data.network.interfaces.PetDataStore;

import java.util.List;

/**
 * Created by JORDINY on 8/11/2017.
 */

public class NetworkPetDataSource implements PetDataSource {
    private final PetDataStore petDataStore;

    public NetworkPetDataSource() {
        this.petDataStore = new RestPetDataStore();
    }

    @Override
    public List<PetEntity> getPetEntityList() throws Exception {
        return petDataStore.getPetEntityList();
    }

    @Override
    public PetEntity getPetEntity(PetEntity petEntity) throws Exception {
        return petDataStore.getPetEntity(petEntity);
    }

    @Override
    public PetEntity insertPetEntity(PetEntity petEntity) throws Exception {
        return petDataStore.insertPetEntity(petEntity);
    }

    @Override
    public PetEntity updatePetEntity(PetEntity petEntity) throws Exception {
        return petDataStore.updatePetEntity(petEntity);
    }

    @Override
    public PetEntity deletePetEntity(PetEntity petEntity) throws Exception {
        return petDataStore.deletePetEntity(petEntity);
    }
}
