package com.sales.collection_data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesViewModel extends ViewModel {
    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<collectionModel>> heroList;

    //we will call this method to get the data
    public LiveData<List<collectionModel>> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<collectionModel>>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);
       /* Call<List<collectionModel>> call = api.getHeroes();


        call.enqueue(new Callback<List<collectionModel>>() {
            @Override
            public void onResponse(Call<List<collectionModel>> call, Response<List<collectionModel>> response) {

                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<collectionModel>> call, Throwable t) {

            }
        });
*/

        Call<List<collectionModel>> call = api.getHeroes();


        call.enqueue(new Callback<List<collectionModel>>() {
            @Override
            public void onResponse(Call<List<collectionModel>> call, Response<List<collectionModel>> response) {

                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<collectionModel>> call, Throwable t) {

            }
        });
    }
}
