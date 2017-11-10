package com.jmf.system.bestpetsite.data.repository.datasource.customer;

import com.jmf.system.bestpetsite.data.entities.CustomerEntity;

import java.util.List;

/**
 * Created by JORDINY on 8/11/2017.
 */

public interface CustomerDataSource {
    List<CustomerEntity> customerEntityList() throws Exception;

    CustomerEntity insertCustomerEntity(CustomerEntity newsEntity) throws Exception;
}
