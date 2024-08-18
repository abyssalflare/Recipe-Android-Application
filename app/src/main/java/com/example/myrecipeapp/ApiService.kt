package com.example.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//Create the retrofit instance
private val retrofit =  Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")//put in the base URL
    .addConverterFactory(GsonConverterFactory.create())//allows the conversion of JSON data to Kotlin data we can use
    .build()//build the instance

//Create the api service using the instance and interface we created
val recipeService = retrofit.create(ApiService::class.java)

interface ApiService
{
    //The API GET request sent to the database to get the categories of food items
    @GET("categories.php")//the endpoint(last part of URL)

    //In Kotlin, the suspend keyword is used to define a function as "suspendable,"
    //meaning it can be paused and resumed at a later time without blocking the thread
    //on which it is running. This is a key concept in Kotlin's coroutines, which are used
    //for writing asynchronous and non-blocking code.
    //Essentially, while retrieving data, other threads can continue running
    suspend fun getCategories(): CategoriesResponse
}


