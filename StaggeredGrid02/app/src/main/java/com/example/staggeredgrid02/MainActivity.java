package com.example.staggeredgrid02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.staggeredgrid02.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private RecAdapter adapter;
    private List<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.recyclerView;

        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mocki.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(CitiesApi.class);

        Call<List<City>> call = retrofit.create(CitiesApi.class).getAll();
        call.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                cities = response.body();
                Log.d("xxx", cities.toString());


                adapter = new RecAdapter(cities);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {

            }
        });



    }
}