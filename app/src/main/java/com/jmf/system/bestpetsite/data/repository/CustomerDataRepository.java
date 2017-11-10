package com.jmf.system.bestpetsite.data.repository;

import com.jmf.system.bestpetsite.data.entities.CustomerEntity;
import com.jmf.system.bestpetsite.data.entities.mapper.CustomerEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.datasource.customer.CustomerDataSource;
import com.jmf.system.bestpetsite.data.repository.datasource.customer.CustomerDataSourceFactory;
import com.jmf.system.bestpetsite.domain.models.Customer;
import com.jmf.system.bestpetsite.domain.repository.CustomerRepository;

import java.util.List;

/**
 * Created by JORDINY on 8/11/2017.
 */

public class CustomerDataRepository implements CustomerRepository {
    private final CustomerDataSourceFactory customerDataSourceFactory;
    private final CustomerEntityDataMapper customerEntityDataMapper;

    public CustomerDataRepository(CustomerDataSourceFactory customerDataSourceFactory, CustomerEntityDataMapper customerEntityDataMapper) {
        this.customerDataSourceFactory = customerDataSourceFactory;
        this.customerEntityDataMapper = customerEntityDataMapper;
    }

    @Override
    public List<Customer> customerList() throws Exception {
        final CustomerDataSource customerDataSource = this.customerDataSourceFactory.createNetworkCustomerDataSource();
        List<CustomerEntity> customerEntityList = customerDataSource.customerEntityList();
        return customerEntityDataMapper.transform(customerEntityList);
    }

    @Override
    public Customer insertCustomer(Customer customer) throws Exception {
        final CustomerDataSource customerDataSource = this.customerDataSourceFactory.createNetworkCustomerDataSource();
        CustomerEntity customerEntity = customerDataSource.insertCustomerEntity(customerEntityDataMapper.transform(customer));
        return customerEntityDataMapper.transform(customerEntity);
    }

}
