package com.jmf.system.bestpetsite.data.repository.datasource.pet;

/**
 * Created by JORDINY on 8/11/2017.
 */

public class PetDataSourceFactory {
    public PetDataSource createNetworkPetDataSource(){
        return new NetworkPetDataSource();
    }
}
