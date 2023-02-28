package meme

import com.google.gson.annotations.SerializedName

data class MemeData (
    @SerializedName("annotations"   ) var annotations  : ArrayList<String> = arrayListOf(),
    @SerializedName("face"          ) var face         : Face?             = Face(),
    @SerializedName("filterId"      ) var filterId     : String?           = null,
    @SerializedName("human_checked" ) var humanChecked : String?           = null,
    @SerializedName("id"            ) var id           : Int?              = null,
    @SerializedName("image"         ) var image        : String?           = null,
    @SerializedName("images"        ) var images       : ArrayList<Images> = arrayListOf(),
    @SerializedName("source_id"     ) var sourceId     : String?           = null,
    @SerializedName("title"         ) var title        : String?           = null,
    @SerializedName("tags"          ) var tags         : Tags?             = Tags()
)