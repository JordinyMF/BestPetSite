package com.jmf.system.bestpetsite.domain.repository;

import com.jmf.system.bestpetsite.domain.models.Customer;

import java.util.List;

/**
 * Created by JORDINY on 9/11/2017.
 */

public interface CustomerRepository {

    List<Customer> customerList() throws Exception;

    Customer insertCustomer(Customer customer) throws Exception;
}
