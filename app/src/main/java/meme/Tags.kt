package meme

import com.google.gson.annotations.SerializedName


data class Tags (

    @SerializedName("topic" ) var topic : ArrayList<Topic> = arrayListOf(),
    @SerializedName("type"  ) var type  : ArrayList<Type>  = arrayListOf()

)