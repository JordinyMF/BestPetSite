package com.jmf.system.bestpetsite.data.repository;

import com.jmf.system.bestpetsite.data.entities.PetEntity;
import com.jmf.system.bestpetsite.data.entities.mapper.PetEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.datasource.pet.PetDataSource;
import com.jmf.system.bestpetsite.data.repository.datasource.pet.PetDataSourceFactory;
import com.jmf.system.bestpetsite.domain.models.Pet;
import com.jmf.system.bestpetsite.domain.repository.PetRepository;

import java.util.List;

/**
 * Created by JORDINY on 18/11/2017.
 */

public class PetDataRepository implements PetRepository {
    private final PetDataSourceFactory petDataSourceFactory;
    private final PetEntityDataMapper petEntityDataMapper;

    public PetDataRepository(PetDataSourceFactory petDataSourceFactory, PetEntityDataMapper petEntityDataMapper) {
        this.petDataSourceFactory = petDataSourceFactory;
        this.petEntityDataMapper = petEntityDataMapper;
    }


    @Override
    public List<Pet> petList() throws Exception {
        final PetDataSource petDataSource = this.petDataSourceFactory.createNetworkPetDataSource();
        List<PetEntity> petEntityList = petDataSource.getPetEntityList();
        return petEntityDataMapper.transform(petEntityList);
    }

    @Override
    public Pet getPet(Pet pet) throws Exception {
        final PetDataSource petDataSource = this.petDataSourceFactory.createNetworkPetDataSource();
        PetEntity petEntity= petDataSource.getPetEntity(petEntityDataMapper.transform(pet));
        return petEntityDataMapper.transform(petEntity);
    }

    @Override
    public Pet insertPet(Pet pet) throws Exception {
        final PetDataSource petDataSource = this.petDataSourceFactory.createNetworkPetDataSource();
        PetEntity petEntity= petDataSource.insertPetEntity(petEntityDataMapper.transform(pet));
        return petEntityDataMapper.transform(petEntity);
    }

    @Override
    public Pet updatePet(Pet pet) throws Exception {
        final PetDataSource petDataSource = this.petDataSourceFactory.createNetworkPetDataSource();
        PetEntity petEntity= petDataSource.updatePetEntity(petEntityDataMapper.transform(pet));
        return petEntityDataMapper.transform(petEntity);
    }

    @Override
    public Pet deletePet(Pet pet) throws Exception {
        final PetDataSource petDataSource = this.petDataSourceFactory.createNetworkPetDataSource();
        PetEntity petEntity= petDataSource.deletePetEntity(petEntityDataMapper.transform(pet));
        return petEntityDataMapper.transform(petEntity);
    }
}
