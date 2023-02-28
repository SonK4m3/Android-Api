package meme

import retrofit2.Call
import retrofit2.http.*
import okhttp3.RequestBody
import okhttp3.MultipartBody

interface MemeApi {
    @GET("meme/pinter_meme_v2/face-image?topic=21&offset=20&num=15")
    fun getMemeResponse(): Call<MemeApiResponse>

    @GET("meme/pinter_meme_v2/face-image")
    fun getMemeResponsePara(@Query("topic") topic: Int, @Query("offset") offset: Int, @Query("num") number: Int): Call<MemeApiResponse>

    @Multipart
    @POST("meme/pinter_meme_v2/face-image")
    fun uploadPhoto(
        @Part("description") description: RequestBody,
        @Part photo: MultipartBody.Part
    ): Call<MemeApiResponse>

    @POST("meme/pinter_meme_v2/face-submit?type=image_msqrd_face")
    fun uploadImageV1(@Body memeData: MemeData): Call<String>
}