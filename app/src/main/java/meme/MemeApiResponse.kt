package meme

import com.google.gson.annotations.SerializedName

data class MemeApiResponse(
    @SerializedName("data") val data: ArrayList<MemeData> = arrayListOf()
)
