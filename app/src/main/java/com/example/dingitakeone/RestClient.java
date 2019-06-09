package com.example.dingitakeone;



import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    public static Retrofit retrofit = null;

    public static Api getClient(Context context) {


        if (retrofit == null) {
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://api.dingi.live/maps/v2/")   //as this is ended with a slash, no slash needed in interface class
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(Api.class);
    }
}
