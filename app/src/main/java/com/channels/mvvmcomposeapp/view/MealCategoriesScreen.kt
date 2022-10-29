package com.channels.mvvmcomposeapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.channels.mvvmcomposeapp.modal.Categories
import com.channels.mvvmcomposeapp.ui.theme.MVVMComposeAppTheme
import com.channels.mvvmcomposeapp.viewmodal.AppViewModal

@Composable
fun MealsCategoryScreen() {
    val viewModel: AppViewModal = viewModel()
    val rememberedMealsList = viewModel.mealsListData.value
    Scaffold(topBar = { AppBar(appBarTitle = "Meals App" ,
        appBarIcon = Icons.Default.Home ,
        contentDescription = "Back Arrow Icon")}) {
        Surface(modifier = Modifier.fillMaxSize() , color = Color.LightGray) {
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(rememberedMealsList) { meal ->
                    MealsCategory(meal)
                }
            }
        }
    }
}

@Composable
fun AppBar(appBarTitle : String = "Meals App",
           appBarIcon : ImageVector = Icons.Default.Home,
           contentDescription : String = "Home Icon"){
    TopAppBar(navigationIcon = {
        Icon(appBarIcon,
            contentDescription = contentDescription ,
            modifier = Modifier
                .padding(12.dp))},
        title = { Text(text = appBarTitle)})
}

@Composable
fun MealsCategory(meal: Categories) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        elevation = 4.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(meal.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .size(240.dp)
            )
            Text(
                text = meal.strCategory.orEmpty(),
                style = MaterialTheme.typography.h4,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = meal.strCategoryDescription.orEmpty(),
                style = MaterialTheme.typography.body1,
                color = Color.LightGray,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVMComposeAppTheme {
        MealsCategoryScreen()
    }
}