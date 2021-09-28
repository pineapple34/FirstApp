package com.example.firstapp.db

data class Quotes(val success: Boolean, val data:ArrayList<Data_quotes>)
data class Data_quotes(val id: Int, val title: String, val image: String, val description: String)
