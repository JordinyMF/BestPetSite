package com.jmf.system.bestpetsite.presentation.view;


import com.jmf.system.bestpetsite.presentation.models.CustomerModel;

import java.util.List;

/**
 * Created by JORDINY on 9/11/2017.
 */

public interface CustomerListView extends LoadingView {
    void renderCustomerList(List<CustomerModel> customerModelList);

    void viewCustomer(CustomerModel customerModel);
}
