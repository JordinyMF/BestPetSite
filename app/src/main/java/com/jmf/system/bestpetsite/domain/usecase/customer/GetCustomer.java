package com.jmf.system.bestpetsite.domain.usecase.customer;

import com.jmf.system.bestpetsite.domain.executor.PostExecutionThread;
import com.jmf.system.bestpetsite.domain.executor.ThreadExecutor;
import com.jmf.system.bestpetsite.domain.models.Customer;
import com.jmf.system.bestpetsite.domain.repository.CustomerRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;

import java.util.List;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class GetCustomer extends UseCase<List<Customer>> {

    private final CustomerRepository customerRepository;
    private List<Customer> customerList;

    public GetCustomer(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, CustomerRepository customerRepository) {
        super(threadExecutor, postExecutionThread);
        this.customerRepository = customerRepository;
    }


    @Override
    protected void buildUseCase() {
        try{
            List<Customer> returnedCustomerList=this.customerRepository.customerList();
            notifyUseCaseSuccess(returnedCustomerList);
        }
        catch (Exception e){
            notifyUseCaseError(e);
        }
    }
}
