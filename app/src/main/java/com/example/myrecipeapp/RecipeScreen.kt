package com.example.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

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
                CategoryScreen(categories = viewState.list)
            }
        }
    }
}

//The list of categories displayed on screen
@Composable
fun CategoryScreen(categories: List<Category>)
{
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize())
    {
        //for every category we have inside the list of categories we pass in, create a new
        //CategoryItem composable, passing in the current category in this iteration as the argument
        //to create the CategoryItem composable
        items(categories)
        {
            category ->
            CategoryItem(category = category)
        }
    }
}

//The composable for each category item
@Composable
fun CategoryItem(category: Category)
{
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            //the implementation for image loading we imported allow us to simply
            //use this method which loads the image for us asynchronously from the Internet
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)//aspect ratio sets image as wide
                                                                    //as it is tall
            )
        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

