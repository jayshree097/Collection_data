package com.sales.collection_data;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    collection_adapter adapter;
//    List<collectionModel> heroList;
//     ArrayList<collectionModel> heroList = new ArrayList<>();



    private ArrayList<collectionModel> heroList;

//    ArrayList<HashMap<String, String>> itemList;
//    List<HashMap<String, String>> itemList = new ArrayList<HashMap<String, String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerView = findViewById(R.id.recy_collection);
        recyclerView.setHasFixedSize(true);

//        heroList.clear();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplication(), LinearLayout.HORIZONTAL));
//        adapter = new collection_adapter(getApplication(),heroList);
//        recyclerView.setAdapter(adapter);



    HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        model.getHeroes().observe(this, new Observer<List<collectionModel>>() {
            @Override
            public void onChanged(@Nullable List<collectionModel> heroList) {
                adapter = new collection_adapter(MainActivity.this, heroList);

                recyclerView.setAdapter(adapter);
            }
        });


    }

}
