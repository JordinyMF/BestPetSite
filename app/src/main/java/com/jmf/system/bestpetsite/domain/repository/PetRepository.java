package com.jmf.system.bestpetsite.domain.repository;

import com.jmf.system.bestpetsite.domain.models.Pet;

import java.util.List;

/**
 * Created by JORDINY on 18/11/2017.
 */

public interface PetRepository {
    List<Pet> petList() throws Exception;

    Pet getPet(Pet pet) throws Exception;

    Pet insertPet(Pet pet) throws Exception;

    Pet updatePet(Pet pet) throws Exception;

    Pet deletePet(Pet pet) throws Exception;
}
