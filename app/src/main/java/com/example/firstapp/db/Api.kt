package com.example.firstapp.db
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("/user/login")
    fun getAuth(@Body hashMap: HashMap<String,String>): Call<Void>

    @GET("feelings")
    fun getFeel():Call<Feelings>
    @GET("quotes")
    fun getQuotes():Call<Quotes>
}