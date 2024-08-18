package com.example.myrecipeapp


data class Category(
    val idCategory: String,
    val strCategory: String,
    val categoryThumb: String,
    val strCategoryDescription: String)

data class CategoriesResponse(val categories: List<Category>)

//API response JSON format, we need to convert it to Kotlin data class(MealDB)
//these are the properties each category has that the MEALDB api response gives us
//"idCategory": "1",
//"strCategory": "Beef",
//"strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
//"strCategoryDescription": "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]"