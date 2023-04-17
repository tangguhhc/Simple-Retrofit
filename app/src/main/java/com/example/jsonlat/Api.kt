package com.example.jsonlat

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET(value = "posts")
    fun getUsers(): Call<ArrayList<PostResponse>>
}