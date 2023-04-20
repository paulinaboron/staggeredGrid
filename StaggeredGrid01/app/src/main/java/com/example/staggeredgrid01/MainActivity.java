package com.example.staggeredgrid01;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.staggeredgrid01.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ArrayList images = new ArrayList<>(Arrays.asList(
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3,
            R.drawable.gory1,
            R.drawable.gory2,
            R.drawable.gory3
            ));

    private RecyclerView recyclerView;
    private RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.recyclerView;

        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        adapter = new RecAdapter(images, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }
}