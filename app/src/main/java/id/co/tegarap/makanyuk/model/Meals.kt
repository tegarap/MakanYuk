package id.co.tegarap.makanyuk.model

import com.google.gson.annotations.SerializedName

data class Meals (
        @SerializedName("strMeal")
        val strMeal: String? = null,
        @SerializedName("strMealThumb")
        val strMealThumb: String? = null,
        @SerializedName("idMeal")
        val idMeal: String? = null
)