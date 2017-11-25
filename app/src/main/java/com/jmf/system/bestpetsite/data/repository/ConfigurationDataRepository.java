package com.jmf.system.bestpetsite.data.repository;

import com.jmf.system.bestpetsite.data.entities.CodesCatalogEntity;
import com.jmf.system.bestpetsite.data.entities.mapper.CodesCatalogEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.datasource.configuration.ConfigurationDataSource;
import com.jmf.system.bestpetsite.data.repository.datasource.configuration.ConfigurationDataSourceFactory;
import com.jmf.system.bestpetsite.domain.models.CodesCatalog;
import com.jmf.system.bestpetsite.domain.repository.ConfigurationRepository;

import java.util.List;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class ConfigurationDataRepository implements ConfigurationRepository {

    private  final ConfigurationDataSourceFactory configurationDataSourceFactory;
    private final CodesCatalogEntityDataMapper codesCatalogEntityDataMapper;

    public ConfigurationDataRepository(ConfigurationDataSourceFactory configurationDataSourceFactory, CodesCatalogEntityDataMapper codesCatalogEntityDataMapper) {
        this.configurationDataSourceFactory = configurationDataSourceFactory;
        this.codesCatalogEntityDataMapper = codesCatalogEntityDataMapper;
    }

    @Override
    public List<CodesCatalog> getCodesListById(int id) throws Exception {
        final ConfigurationDataSource configurationDataSource=this.configurationDataSourceFactory.createNetworkConfigurationDataSource();
        List<CodesCatalogEntity> codesCatalogEntityList=configurationDataSource.getCodesListById(id);
        return codesCatalogEntityDataMapper.transform(codesCatalogEntityList);
    }
}
