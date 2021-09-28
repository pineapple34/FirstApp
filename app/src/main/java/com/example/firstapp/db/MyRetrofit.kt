package com.example.firstapp.db

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}