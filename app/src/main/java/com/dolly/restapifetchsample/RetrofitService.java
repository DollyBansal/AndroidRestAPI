package com.dolly.restapifetchsample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("/json_data.json")
    Call<PoJoData> getData();
}