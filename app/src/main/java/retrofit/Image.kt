package retrofit

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int,
    @SerializedName("url") var url: String
){

}
