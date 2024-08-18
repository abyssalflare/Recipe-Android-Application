package com.example.myrecipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier
)
{
    //create our viewmodel object which will present us the data we need to display on our screen
    val recipeViewModel: MainViewModel = viewModel()

    //delegate the job of the declared variable to the public property using "by" in the ViewModel class so we can access its
    //value directly without using .value as it is like we are directly using the property inside the ViewModel class when we
    //use this variable
    val viewState by recipeViewModel.categoriesState

    //we will use a box for our layout
    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        when
        {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(alignment = Alignment.Center))
            }
            viewState.error != null ->
            {
                Text(text = "Error Occurred")
            }
            else ->
            {
                //Display Categories
            }
        }
    }
}
