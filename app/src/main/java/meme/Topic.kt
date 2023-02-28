package meme

import com.google.gson.annotations.SerializedName


data class Topic (

    @SerializedName("name"  ) var name  : String?           = null,
    @SerializedName("value" ) var value : ArrayList<String> = arrayListOf()

)