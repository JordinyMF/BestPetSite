package com.jmf.system.bestpetsite.data.repository.datasource.PetControlType;

import com.jmf.system.bestpetsite.data.entities.PetControlTypeEntity;
import com.jmf.system.bestpetsite.data.network.implementations.RestPetControlTypeDataStore;
import com.jmf.system.bestpetsite.data.network.interfaces.PetControlTypeDataStore;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class NetworkPetControlTypeDataSource implements PetControlTypeDataSource {
    private final PetControlTypeDataStore petControlTypeDataStore;

    public NetworkPetControlTypeDataSource() {
        this.petControlTypeDataStore = new RestPetControlTypeDataStore();
    }
    @Override
    public PetControlTypeEntity insertPetControlTypeEntity(PetControlTypeEntity petControlTypeEntity) throws Exception {
        return petControlTypeDataStore.insertPetControlTypeEntity(petControlTypeEntity);
    }
}
