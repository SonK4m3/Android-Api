package retrofit

import retrofit2.Call
import retrofit2.http.GET


interface TopicApi {
    @GET("meme/pinter_meme_v2/face-topic")
    fun getTopics(): Call<TopicList>
}