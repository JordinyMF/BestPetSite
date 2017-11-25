package com.jmf.system.bestpetsite.data.network.implementations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jmf.system.bestpetsite.BPSApplication;
import com.jmf.system.bestpetsite.data.entities.BaseResponseEntity;
import com.jmf.system.bestpetsite.data.entities.CodesCatalogEntity;
import com.jmf.system.bestpetsite.data.exception.NetworkConnectionException;
import com.jmf.system.bestpetsite.data.network.interfaces.ConfigurationDataStore;
import com.jmf.system.bestpetsite.data.network.retrofit.ApiClient;

import java.util.List;

import retrofit2.Response;

/**
 * Created by JORDINY on 24/11/2017.
 */

public class RestConfigurationDataStore implements ConfigurationDataStore {
    private String errorConnection="no hay conexión a internet";

    @Override
    public List<CodesCatalogEntity> getCodesListById(int id) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<List<CodesCatalogEntity>>> response = ApiClient.getApi().getCodesListById(id).execute();
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
