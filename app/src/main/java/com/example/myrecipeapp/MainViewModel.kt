package com.example.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//this ViewModel class essentially calls the APIs in the ApiService file and presents the data
//for the View to use to display to the user
class MainViewModel: ViewModel() {

    //the private property which stores the mutable state of the categories
    private val _categoriesState = mutableStateOf(RecipeState())

    //everytime the state of the value it holds changes, the composable will recompose and this State will subscribe
    //to the new value of the private mutablestate
    val categoriesState: State<RecipeState> = _categoriesState

    //Get the categories when we create the ViewModel inside the main class
    init {
        fetchCategories()
    }

    //the function which calls the API in the ApiService file
    private fun fetchCategories()
    {
        //this is how you launch a coroutine inside of Kotlin
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }
            catch (e: Exception)
            {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }

    //the data class which holds the state of our list of categories
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )

}