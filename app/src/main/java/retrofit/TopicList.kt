package retrofit

import com.google.gson.annotations.SerializedName

data class TopicList(
    @SerializedName("data") val listTopic: List<Topic>
){

}
