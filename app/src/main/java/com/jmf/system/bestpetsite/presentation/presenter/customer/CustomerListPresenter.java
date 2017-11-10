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
import com.jmf.system.bestpetsite.domain.usecase.customer.GetCustomer;
import com.jmf.system.bestpetsite.presentation.exception.ErrorMessageFactory;
import com.jmf.system.bestpetsite.presentation.models.CustomerModel;
import com.jmf.system.bestpetsite.presentation.models.mapper.CustomerModelDataMapper;
import com.jmf.system.bestpetsite.presentation.presenter.BasePresenter;
import com.jmf.system.bestpetsite.presentation.view.CustomerListView;

import java.util.List;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class CustomerListPresenter extends BasePresenter<CustomerListView> {
    private final GetCustomer getCustomer;
    private final CustomerModelDataMapper customerModelDataMapper;

    public CustomerListPresenter(CustomerListView view) {
        super(view);
        final CustomerRepository customerRepository = new CustomerDataRepository(
                new CustomerDataSourceFactory(), new CustomerEntityDataMapper());
        this.getCustomer = new GetCustomer(new JobExecutor(), new UIThread(), customerRepository);
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
        getCustomer.cancel();
        view = null;
    }
    private void renderCustomerListInView(List<Customer> customerList) {
        view.renderCustomerList(customerModelDataMapper.transform(customerList));
    }

    public void onCustomerClicked(CustomerModel customerModel) {
        view.viewCustomer(customerModel);
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }

    private void showLoadingView() {
        view.showLoading();
    }

    private void hideLoadingView() {
        view.hideLoading();
    }

    public void getCustomerList() {
        showLoadingView();
        getCustomer.execute(new UseCase.Callback<List<Customer>>() {
            @Override
            public void onSuccess(List<Customer> customerList) {
                hideLoadingView();
                renderCustomerListInView(customerList);
            }

            @Override
            public void onError(Throwable e) {
                hideLoadingView();
                showErrorMessage(new DefaultErrorBundle((Exception) e));
            }
        });
    }
}
