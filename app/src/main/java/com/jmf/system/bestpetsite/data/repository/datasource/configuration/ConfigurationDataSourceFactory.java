package com.jmf.system.bestpetsite.data.repository.datasource.configuration;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class ConfigurationDataSourceFactory {
        public ConfigurationDataSource createNetworkConfigurationDataSource() {

            return new NetworkConfigurationDataSource();
        }
}
