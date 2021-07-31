package com.juaracoding.katalogfrontend;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.juaracoding.katalogfrontend.adapter.KatalogAdapter;
import com.juaracoding.katalogfrontend.entity.Katalog;
import com.juaracoding.katalogfrontend.entity.Response;
import com.juaracoding.katalogfrontend.service.ApiClient;
import com.juaracoding.katalogfrontend.service.KatalogInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Katalog> katalogArrayList;
    private KatalogAdapter katalogAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KatalogInterface katalogInterface = ApiClient.getRetrovit().create(KatalogInterface.class);
        Call<Response> call = katalogInterface.getAllKatalog();
        call.enqueue(new Callback<Response>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                katalogArrayList = (ArrayList<Katalog>) response.body().getData();
                katalogAdapter = new KatalogAdapter(katalogArrayList, MainActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(katalogAdapter);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}