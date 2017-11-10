package com.jmf.system.bestpetsite.data.entities.mapper;

import com.jmf.system.bestpetsite.data.entities.CustomerEntity;
import com.jmf.system.bestpetsite.domain.models.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class CustomerEntityDataMapper {

    public Customer transform(CustomerEntity customerEntity){
        Customer customer=new Customer();
        customer.setId(customerEntity.getId());
        customer.setIdCustomerType(customerEntity.getIdCustomerType());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setPhone(customerEntity.getPhone());
        customer.setDirection(customerEntity.getDirection());
        customer.setStatus(customerEntity.getStatus());
        return customer;
    }
    public List<Customer> transform(List<CustomerEntity> customerEntityList) {
        List<Customer> customerList = new ArrayList<>();
        for(CustomerEntity customerEntity : customerEntityList) {
            customerList.add(transform(customerEntity));
        }
        return customerList;
    }

    public CustomerEntity transform(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setIdCustomerType(customer.getIdCustomerType());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setDirection(customer.getDirection());
        customerEntity.setStatus(customer.getStatus());
        return customerEntity;
    }
}
