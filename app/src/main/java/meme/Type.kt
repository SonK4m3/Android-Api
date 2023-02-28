package meme

import com.google.gson.annotations.SerializedName


data class Type (

    @SerializedName("name"  ) var name  : String?           = null,
    @SerializedName("value" ) var value : ArrayList<String> = arrayListOf()

)