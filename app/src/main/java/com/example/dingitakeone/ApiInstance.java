package com.example.dingitakeone;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiInstance {

    public static final String Base_url = "https://api.dingi.live/maps/v2/";
    public  static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }



    //this is the real code
//
//    //api client
//    Retrofit retrofit = new Retrofit
//            .Builder()
//            .baseUrl("https://api.dingi.live/maps/v2/")   //as this is ended with a slash, no slash needed in interface class
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    Api api = retrofit.create(Api.class);
//    Call<Data> call;
//    //TODO PUT THE HEADER LIKE THIS
//    call = api.getData("ru7KPUg2Wj17lRGdT1mTn9fCbYYSI2Ojaop8iwB5",""+placeSearch, "en");

}
