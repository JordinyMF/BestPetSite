package com.jmf.system.bestpetsite.data.network.retrofit;

import com.jmf.system.bestpetsite.data.entities.BaseResponseEntity;
import com.jmf.system.bestpetsite.data.entities.CustomerEntity;
import com.jmf.system.bestpetsite.data.entities.PetEntity;
import com.jmf.system.bestpetsite.data.entities.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by JORDINY on 6/11/2017.
 */

public interface ServiceInterface {
    String BASE_URL = "http://www.bestpetsite.somee.com/bestpetsite/api/v1/";

    /*********************************** USER ************************************* INI*/
    @FormUrlEncoded
    @POST("token")
    Call<UserEntity> loginUserEntity(@Field("grant_type") String grant_Type,
                                     @Field("username") String userName,
                                     @Field("password") String password);

    @GET("users")
    Call<BaseResponseEntity<List<UserEntity>>> getUserList();

    @POST("users")
    Call<BaseResponseEntity<UserEntity>> insertUser(@Body UserEntity userEntity);

    @PUT("users")
    Call<BaseResponseEntity<UserEntity>> updateUser(@Body UserEntity userEntity);

    @DELETE("users/{id}")
    Call<BaseResponseEntity<UserEntity>> deleteUser(@Path("id") int id);
    /*********************************** USER ************************************* FIN*/

    /*********************************** PET ************************************* INI*/
    @GET("pets")
    Call<BaseResponseEntity<List<PetEntity>>> getPetList();

    @GET("pets/{id}")
    Call<BaseResponseEntity<PetEntity>> getPet(@Path("id") int id);

    @POST("pets")
    Call<BaseResponseEntity<PetEntity>> insertPet(@Body PetEntity petEntity);

    @PUT("pets")
    Call<BaseResponseEntity<PetEntity>>  updatePet(@Body PetEntity petEntity);

    @DELETE("pets/{id}")
    Call<BaseResponseEntity<PetEntity>> deletePet(@Path("id") int id);

    /*********************************** PET ************************************* FIN*/


    /*********************************** CUSTOMER ************************************* INI*/
    @GET("customers")
    Call<BaseResponseEntity<List<CustomerEntity>>> getCustomerList();

    @Headers("Content-Type: application/json")
    @POST("customers")
    Call<BaseResponseEntity<CustomerEntity>> postCustomer(@Body CustomerEntity body);
    /*********************************** CUSTOMER ************************************* FIN*/
}
