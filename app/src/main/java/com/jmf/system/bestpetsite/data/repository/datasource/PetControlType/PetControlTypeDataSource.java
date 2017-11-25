package com.jmf.system.bestpetsite.data.repository.datasource.PetControlType;

import com.jmf.system.bestpetsite.data.entities.PetControlTypeEntity;

/**
 * Created by JORDINY on 25/11/2017.
 */

public interface PetControlTypeDataSource {

    PetControlTypeEntity insertPetControlTypeEntity(PetControlTypeEntity petControlTypeEntity) throws Exception;
}
