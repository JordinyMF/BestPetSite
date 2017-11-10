package com.jmf.system.bestpetsite.data.repository.datasource.user;

import com.jmf.system.bestpetsite.data.network.interfaces.UserDataStore;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class UserDataSourceFactoy {

    public UserDataSource createNetworkUserDataSource(){
        return new NetworkUserDataSource();
    }
}
