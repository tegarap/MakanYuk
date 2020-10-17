package id.co.tegarap.makanyuk.api

import com.google.gson.annotations.SerializedName
import id.co.tegarap.makanyuk.model.Meals

data class ResponseSeafood (
        @SerializedName("meals")
        val meals: ArrayList<Meals>?
)