package retrofit

import com.google.gson.annotations.SerializedName

data class Topic(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
){}
