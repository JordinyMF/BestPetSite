package com.jmf.system.bestpetsite.data.network.implementations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jmf.system.bestpetsite.BPSApplication;
import com.jmf.system.bestpetsite.data.entities.BaseResponseEntity;
import com.jmf.system.bestpetsite.data.entities.PetEntity;
import com.jmf.system.bestpetsite.data.exception.NetworkConnectionException;
import com.jmf.system.bestpetsite.data.network.interfaces.PetDataStore;
import com.jmf.system.bestpetsite.data.network.retrofit.ApiClient;

import java.util.List;

import retrofit2.Response;

/**
 * Created by JORDINY on 18/11/2017.
 */

public class RestPetDataStore implements PetDataStore {
    private String errorConnection = "no hay conexión a internet";

    @Override
    public List<PetEntity> getPetEntityList() throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<List<PetEntity>>> response = ApiClient.getApi().getPetList().execute();
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
    public PetEntity getPetEntity(PetEntity petEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<PetEntity>> response = ApiClient.getApi().getPet(petEntity.getId()).execute();
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
    public PetEntity insertPetEntity(PetEntity petEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<PetEntity>> response = ApiClient.getApiToken().insertPet(petEntity).execute();
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
    public PetEntity updatePetEntity(PetEntity petEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<PetEntity>> response = ApiClient.getApi().updatePet(petEntity).execute();
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
    public PetEntity deletePetEntity(PetEntity petEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<PetEntity>> response = ApiClient.getApi().deletePet(petEntity.getId()).execute();
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
