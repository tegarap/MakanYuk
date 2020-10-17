package id.co.tegarap.makanyuk.api

import com.google.gson.annotations.SerializedName
import id.co.tegarap.makanyuk.model.Seafood

data class ResponseDetail (
        @SerializedName("meals")
        val mealsSeafood: ArrayList<Seafood>?
)