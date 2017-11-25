package com.jmf.system.bestpetsite.data.repository.datasource.configuration;

import com.jmf.system.bestpetsite.data.entities.CodesCatalogEntity;
import com.jmf.system.bestpetsite.data.network.implementations.RestConfigurationDataStore;
import com.jmf.system.bestpetsite.data.network.interfaces.ConfigurationDataStore;

import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class NetworkConfigurationDataSource implements ConfigurationDataSource{
    private final ConfigurationDataStore configurationDataStore;

    public NetworkConfigurationDataSource() {
        this.configurationDataStore = new RestConfigurationDataStore();
    }


    @Override
    public List<CodesCatalogEntity> getCodesListById(int id) throws Exception {
        return configurationDataStore.getCodesListById(id);
    }
}
