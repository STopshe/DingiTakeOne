package com.example.dingitakeone;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface Api {


    @Headers("x-api-key: ru7KPUg2Wj17lRGdT1mTn9fCbYYSI2Ojaop8iwB5")
    @FormUrlEncoded
    @GET("/search")
    Call<Data> getData(@Query("q") String jayga, @Query("language") String bhasha);
}

