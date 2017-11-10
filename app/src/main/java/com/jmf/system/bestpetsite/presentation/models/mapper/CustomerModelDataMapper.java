package com.jmf.system.bestpetsite.presentation.models.mapper;

import com.jmf.system.bestpetsite.domain.models.Customer;
import com.jmf.system.bestpetsite.presentation.models.CustomerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class CustomerModelDataMapper {

    public CustomerModel transform(Customer customer){
        CustomerModel customerModel=new CustomerModel();
        customerModel.setId(customer.getId());
        customerModel.setIdCustomerType(customer.getIdCustomerType());
        customerModel.setFirstName(customer.getFirstName());
        customerModel.setLastName(customer.getLastName());
        customerModel.setPhone(customer.getPhone());
        customerModel.setDirection(customer.getDirection());
        customerModel.setStatus(customer.getStatus());
        return customerModel;
    }
    public List<CustomerModel> transform(List<Customer> customerList) {
        List<CustomerModel> customerModelList = new ArrayList<>();
        for(Customer customer : customerList) {
            customerModelList.add(transform(customer));
        }
        return customerModelList;
    }

    public Customer transform(CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.setId(customerModel.getId());
        customer.setIdCustomerType(customerModel.getIdCustomerType());
        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        customer.setPhone(customerModel.getPhone());
        customer.setDirection(customerModel.getDirection());
        customer.setStatus(customerModel.getStatus());
        return customer;
    }
}
