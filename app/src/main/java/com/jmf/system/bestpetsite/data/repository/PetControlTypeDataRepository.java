package com.jmf.system.bestpetsite.data.repository;

import com.jmf.system.bestpetsite.data.entities.PetControlTypeEntity;
import com.jmf.system.bestpetsite.data.entities.mapper.PetControlTypeEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.datasource.PetControlType.PetControlTypeDataSource;
import com.jmf.system.bestpetsite.data.repository.datasource.PetControlType.PetControlTypeDataSourceFactory;
import com.jmf.system.bestpetsite.domain.models.PetControlType;
import com.jmf.system.bestpetsite.domain.repository.PetControlTypeRepository;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class PetControlTypeDataRepository implements PetControlTypeRepository {
    private  final PetControlTypeDataSourceFactory petControlTypeDataSourceFactory;
    private final PetControlTypeEntityDataMapper petControlTypeEntityDataMapper;

    public PetControlTypeDataRepository(PetControlTypeDataSourceFactory petControlTypeDataSourceFactory, PetControlTypeEntityDataMapper petControlTypeEntityDataMapper) {
        this.petControlTypeDataSourceFactory = petControlTypeDataSourceFactory;
        this.petControlTypeEntityDataMapper = petControlTypeEntityDataMapper;
    }
    @Override
    public PetControlType insertPetControlType(PetControlType petControlType) throws Exception {
        final PetControlTypeDataSource petControlTypeDataSource = this.petControlTypeDataSourceFactory.createNetworkPetControlTypeDataSource();
        PetControlTypeEntity userEntity = petControlTypeDataSource.insertPetControlTypeEntity(petControlTypeEntityDataMapper.transform(petControlType));
        return petControlTypeEntityDataMapper.transform(userEntity);
    }
}
