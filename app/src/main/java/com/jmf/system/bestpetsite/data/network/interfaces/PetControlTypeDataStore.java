package com.jmf.system.bestpetsite.data.network.interfaces;

import com.jmf.system.bestpetsite.data.entities.PetControlTypeEntity;

/**
 * Created by JORDINY on 25/11/2017.
 */

public interface PetControlTypeDataStore {
    PetControlTypeEntity insertPetControlTypeEntity(PetControlTypeEntity petControlTypeEntity) throws Exception;
}
