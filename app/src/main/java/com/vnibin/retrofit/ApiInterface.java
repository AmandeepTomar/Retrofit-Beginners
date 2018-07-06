package com.vnibin.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by vnibin on 6/7/18.
 */

public interface ApiInterface {



    @GET("jsonparsetutorial.txt")              //contains the end point of base url
    Call<ApiResponse> getContacts();


}
