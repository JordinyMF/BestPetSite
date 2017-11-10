package com.jmf.system.bestpetsite.presentation.presenter.customer;

import com.jmf.system.bestpetsite.data.entities.mapper.CustomerEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.CustomerDataRepository;
import com.jmf.system.bestpetsite.data.repository.datasource.customer.CustomerDataSourceFactory;
import com.jmf.system.bestpetsite.domain.exception.DefaultErrorBundle;
import com.jmf.system.bestpetsite.domain.exception.ErrorBundle;
import com.jmf.system.bestpetsite.domain.executor.JobExecutor;
import com.jmf.system.bestpetsite.domain.executor.UIThread;
import com.jmf.system.bestpetsite.domain.models.Customer;
import com.jmf.system.bestpetsite.domain.repository.CustomerRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;
import com.jmf.system.bestpetsite.domain.usecase.customer.AddCustomer;
import com.jmf.system.bestpetsite.presentation.exception.ErrorMessageFactory;
import com.jmf.system.bestpetsite.presentation.models.CustomerModel;
import com.jmf.system.bestpetsite.presentation.models.mapper.CustomerModelDataMapper;
import com.jmf.system.bestpetsite.presentation.presenter.BasePresenter;
import com.jmf.system.bestpetsite.presentation.view.AddCustomerView;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class AddCustomerPresenter extends BasePresenter<AddCustomerView> {

    private final AddCustomer addCustomer;
    private final CustomerModelDataMapper customerModelDataMapper;

    public AddCustomerPresenter(AddCustomerView view) {
        super(view);
        final CustomerRepository customerRepository = new CustomerDataRepository(
                new CustomerDataSourceFactory(), new CustomerEntityDataMapper());
        this.addCustomer = new AddCustomer(new JobExecutor(), new UIThread(), customerRepository);
        this.customerModelDataMapper = new CustomerModelDataMapper();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        addCustomer.cancel();
        view = null;
    }
    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }
    private void showLoadingView(){
        view.showLoading();
    }
    private void hideLoadingView(){
        view.hideLoading();
    }
    private void notifySaveCustomerSuccess(Customer customer) {
        view.onCustomerSuccess(customerModelDataMapper.transform(customer));
    }

public void saveCustomer(CustomerModel customerModel){
        showLoadingView();
        addCustomer.setParams(customerModelDataMapper.transform(customerModel));
        addCustomer.execute(new UseCase.Callback<Customer>() {
            @Override
            public void onSuccess(Customer customer) {
                hideLoadingView();
                notifySaveCustomerSuccess(customer);
            }

            @Override
            public void onError(Throwable e) {
                hideLoadingView();
                showErrorMessage(new DefaultErrorBundle((Exception) e));
            }
        });
    }

}
