package com.example.mainviewmodel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRetrofit {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var dogApiService = retrofit.create(DogApiService::class.java)

   public fun dogApiServiceCallBack() : DogApiService = dogApiService


}