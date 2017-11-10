package com.jmf.system.bestpetsite.data.repository.datasource.customer;

import com.jmf.system.bestpetsite.data.entities.CustomerEntity;
import com.jmf.system.bestpetsite.data.network.implementations.RestCustomerDataStore;
import com.jmf.system.bestpetsite.data.network.interfaces.CustomerDataStore;

import java.util.List;

/**
 * Created by JORDINY on 8/11/2017.
 */

public class NetworkCustomerDataSource implements CustomerDataSource {

    private final   CustomerDataStore customerDataStore;

    public NetworkCustomerDataSource() {
        customerDataStore = new RestCustomerDataStore();
    }

    @Override
    public List<CustomerEntity> customerEntityList() throws Exception {
        return customerDataStore.customerEntityList();
    }

    @Override
    public CustomerEntity insertCustomerEntity(CustomerEntity customerEntity) throws Exception {
        return customerDataStore.insertCustomerEntity(customerEntity);
    }
}
