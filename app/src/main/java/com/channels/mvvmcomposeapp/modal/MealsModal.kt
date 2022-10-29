package com.channels.mvvmcomposeapp.modal

data class MealsModal(var categories : MutableList<Categories>)

data class Categories(var idCategory : Int? = Int.MIN_VALUE ,
                      var strCategory : String? = null ,
                      var strCategoryThumb : String? = null ,
                      var strCategoryDescription : String? = null)