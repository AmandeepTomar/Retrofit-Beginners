package com.vnibin.retrofit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ReyclerAdapter adapter;
    private List<WorldPopulation> worldPopulations;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiInterface.getContacts();


        // your way is the way you hit the api , as i told you you just make a mistake there in api the response is a json object first then the json array
        // or you try to parse the code using json array so it throw the error. and tell us , Begin with array but was begin object  Hapiee coding.
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                try {
                    int statusCOde = response.code();
                    Log.e("statusCode", statusCOde + " received");
                    if (statusCOde == 200) {
                        List<WorldPopulation> data = response.body().getWorldpopulation();
                        adapter = new ReyclerAdapter(data, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    } else {
                        // here you need to put the code for error or exception checking
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });




    }
}
