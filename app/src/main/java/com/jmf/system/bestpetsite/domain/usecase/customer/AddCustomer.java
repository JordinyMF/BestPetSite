package com.jmf.system.bestpetsite.domain.usecase.customer;

import com.jmf.system.bestpetsite.domain.executor.PostExecutionThread;
import com.jmf.system.bestpetsite.domain.executor.ThreadExecutor;
import com.jmf.system.bestpetsite.domain.models.Customer;
import com.jmf.system.bestpetsite.domain.repository.CustomerRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;

/**
 * Created by JORDINY on 9/11/2017.
 */

public  class AddCustomer extends UseCase<Customer> {
    private final CustomerRepository customerRepository;
    private Customer customer;

    public AddCustomer(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread, CustomerRepository customerRepository) {
        super(threadExecutor, postExecutionThread);

        this.customerRepository = customerRepository;
    }

    public void setParams(Customer customer){this.customer=customer;}

    @Override
    protected void buildUseCase() {
        try{
            Customer returnedCustomer=this.customerRepository.insertCustomer(this.customer);
            notifyUseCaseSuccess(returnedCustomer);
        }catch (Exception e){
            notifyUseCaseError(e);
        }
    }
}
