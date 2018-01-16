package com.dolly.restapifetchsample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    // http://pratikbutani.x10.mx/json_data.json

    public static RetrofitService getRetrofitService() {
        String url = "http://pratikbutani.x10.mx";
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService.class);
    }
}
