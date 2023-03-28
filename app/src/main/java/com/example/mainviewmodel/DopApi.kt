package com.example.mainviewmodel

import android.provider.ContactsContract
import retrofit2.http.GET

interface DogApiService {
        @GET("breeds/image/random")
        suspend fun getRandomDogImage(): retrofit2.Response <DtoObject>

        //posso mettere più get e più suspend fun
    }
