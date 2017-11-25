package com.jmf.system.bestpetsite.data.repository.datasource.PetControlType;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class PetControlTypeDataSourceFactory {

    public PetControlTypeDataSource createNetworkPetControlTypeDataSource(){
        return new NetworkPetControlTypeDataSource();
    }
}
