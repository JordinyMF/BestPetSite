package com.jmf.system.bestpetsite.data.repository.datasource.customer;


/**
 * Created by JORDINY on 8/11/2017.
 */

public class CustomerDataSourceFactory {

    public CustomerDataSource createNetworkCustomerDataSource() {

        return new NetworkCustomerDataSource();
    }
}
