package com.jmf.system.bestpetsite.domain.repository;

import com.jmf.system.bestpetsite.domain.models.PetControlType;

/**
 * Created by JORDINY on 25/11/2017.
 */

public interface PetControlTypeRepository {
    PetControlType insertPetControlType(PetControlType petControlType) throws Exception;
}
