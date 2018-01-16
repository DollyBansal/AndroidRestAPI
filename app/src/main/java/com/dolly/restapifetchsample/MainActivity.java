package com.dolly.restapifetchsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_feed);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<PoJoDataNext> data = new ArrayList<>();
        RecyclerViewAdapterCustom rcAdapter = new RecyclerViewAdapterCustom(this, data);
        recyclerView.setAdapter(rcAdapter);
        recyclerView.setHasFixedSize(true);
        fetchData(rcAdapter, data);
    }

    private void fetchData(final RecyclerViewAdapterCustom rcAdapter, final ArrayList<PoJoDataNext> data) {
        Call<PoJoData> call = RestClient.getRetrofitService().
                getData();

        call.enqueue(new Callback<PoJoData>() {
            @Override
            public void onResponse(Call<PoJoData> call, Response<PoJoData> response) {
                if (!ErrorHandlingUtil.isCorrectInstagramResponse(getApplicationContext(), response.body())) {
                    return;
                }

                System.out.println("dolly" +
                        "response = " + response.body().getContacts());

                // The good case. Everything is alright, and we got the data.
                if (response.body().getContacts() != null) {
                    for (int i = 0; i < response.body().getContacts().size(); i++) {
                        data.add(response.body().getContacts().get(i));
                    }
                    //notify the recycler view about the new data
                    rcAdapter.notifyItemInserted(data.size());
                } else {
                    ErrorHandlingUtil.showErrorToUser(getApplicationContext(), "Something went wrong. Data returned is null");
                }
            }

            @Override
            public void onFailure(Call<PoJoData> call, Throwable t) {
                ErrorHandlingUtil.showErrorToUser(getApplicationContext(), t.toString());
            }
        });


    }
}
