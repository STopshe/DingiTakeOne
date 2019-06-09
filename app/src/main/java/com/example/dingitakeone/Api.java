package com.example.dingitakeone;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface Api {
    //TODO YOUR HEADER  APPROACH WAS WRONG
    @GET("search")   //Here was a extra slash  /search
    Call<Data> call(@Header ("x-api-key")String header, @Query("q") String jayga, @Query("language") String bhasha);
}

