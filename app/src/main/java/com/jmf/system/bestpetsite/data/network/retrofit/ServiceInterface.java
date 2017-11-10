package com.jmf.system.bestpetsite.data.network.retrofit;

import com.jmf.system.bestpetsite.data.entities.BaseResponseEntity;
import com.jmf.system.bestpetsite.data.entities.CustomerEntity;
import com.jmf.system.bestpetsite.data.entities.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by JORDINY on 6/11/2017.
 */

public interface ServiceInterface {
    String BASE_URL = "http://www.bestpetsite.somee.com/bestpetsite/api/v1/";

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("token")
    Call<UserEntity> loginUserEntity(@Body UserEntity body);

    @GET("customers")
    Call<BaseResponseEntity<List<CustomerEntity>>> getCustomerList();

    @Headers("Content-Type: application/json")
    @POST("customers")
    Call<BaseResponseEntity<CustomerEntity>> postCustomer(@Body CustomerEntity body);

}
