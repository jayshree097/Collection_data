package com.sales.collection_data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
   /* @FormUrlEncoded
    @POST("/posts")
    Observable<List<collectionModel>> posts (@FieldMap HashMap<String, String> params);*/

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

   @GET("posts")
   Call<List<collectionModel>> getHeroes();



}
