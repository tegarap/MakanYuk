package id.co.tegarap.makanyuk.model

import com.google.gson.annotations.SerializedName

data class Seafood (
        @SerializedName("idMeal")
        val idMeal: String? = null,

        @SerializedName("strMeal")
        val strMeal: String? = null,

        @SerializedName("strCategory")
        val strCategory: String? = null,

        @SerializedName("strArea")
        val strArea: String? = null,

        @SerializedName("strInstructions")
        val strInstructions: String? = null,

        @SerializedName("strMealThumb")
        val strMealThumb: String? = null,

        @SerializedName("strTags")
        val strTags: String? = null,

        @SerializedName("strYoutube")
        val strYoutube: String? = null
)