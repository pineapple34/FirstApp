package com.example.firstapp.db

data class Feelings(val success: Boolean, val data:ArrayList<Data_feelings>)
data class Data_feelings(val id: Int, val title: String, val image: String, val position: Int)
