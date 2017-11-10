package com.jmf.system.bestpetsite.data.network.implementations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jmf.system.bestpetsite.BPSApplication;
import com.jmf.system.bestpetsite.data.entities.BaseResponseEntity;
import com.jmf.system.bestpetsite.data.entities.CustomerEntity;
import com.jmf.system.bestpetsite.data.exception.NetworkConnectionException;
import com.jmf.system.bestpetsite.data.network.interfaces.CustomerDataStore;
import com.jmf.system.bestpetsite.data.network.retrofit.ApiClient;

import java.util.List;

import retrofit2.Response;

/**
 * Created by JORDINY on 8/11/2017.
 */

public class RestCustomerDataStore implements CustomerDataStore {
 private String errorConnection="no hay conexión a internet";

    @Override
    public List<CustomerEntity> customerEntityList() throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<List<CustomerEntity>>> response = ApiClient.getApi().getCustomerList().execute();
        if (response.isSuccessful()) {
            if (response.body().isOk()) {
                return response.body().getContent();
            } else {
                throw new NetworkConnectionException(response.body().getResponse().getMessage());
            }
        } else {
            throw new NetworkConnectionException();
        }
    }

    @Override
    public CustomerEntity insertCustomerEntity(CustomerEntity customerEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<CustomerEntity>> response = ApiClient.getApi().postCustomer(customerEntity).execute();
        if (response.isSuccessful()) {
            if (response.body().isOk()) {
                return response.body().getContent();
            } else {
                throw new NetworkConnectionException(response.body().getResponse().getMessage());
            }
        } else {
            throw new NetworkConnectionException();
        }
    }

   private boolean isThereInternetConnection() {
        boolean isConnected;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) BPSApplication.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
