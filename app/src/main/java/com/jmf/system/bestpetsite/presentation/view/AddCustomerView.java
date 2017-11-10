package com.jmf.system.bestpetsite.presentation.view;

import com.jmf.system.bestpetsite.presentation.models.CustomerModel;

/**
 * Created by JORDINY on 9/11/2017.
 */

public interface AddCustomerView extends LoadingView{
    void saveCustomer(CustomerModel customerModel);

    void onCustomerSuccess(CustomerModel customerModel);
}
