package meme

import com.google.gson.annotations.SerializedName

data class Face(
    @SerializedName("boxH" ) var boxH : String? = null,
    @SerializedName("boxW" ) var boxW : String? = null,
    @SerializedName("xMin" ) var xMin : String? = null,
    @SerializedName("yMin" ) var yMin : String? = null
)
