package retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.SubmitImageLayoutBinding
import com.google.gson.Gson
import meme.MemeApi
import meme.MemeData
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SubmitImageActivity: AppCompatActivity() {

    companion object {
        const val BASE_URL = "https://mangaverse.skymeta.pro"
    }

    private lateinit var binding: SubmitImageLayoutBinding

    val jsonData = """
        {
    "annotations": [
        "Hinata",
        "Humor",
        "Naruto Kakashi",
        "Anime Naruto",
        "Naruto Pics",
        "Thicc Anime",
        "Hot Anime",
        "Naruto Cute",
        "Anime Guys",
        "Anime Demon",
        "Anime Characters",
        "Character Design"
    ],
        "face": {
        "boxH": "0.577102959156036",
            "boxW": "0.446167230606079",
                "xMin": "0.182595789432526",
                    "yMin": "0.193059638142586"
    },
    "filterId": "2",
        "human_checked": "denied",
            "id": 126382,
                "image": "https://i.pinimg.com/originals/27/44/7d/27447ddaba3dc39dfd2b03ec8405b14b.jpg",
                    "images": [
                        {
                            "height": 136,
                            "url": "https://i.pinimg.com/136x136/27/44/7d/27447ddaba3dc39dfd2b03ec8405b14b.jpg",
                            "width": 136
                        },
                        {
                            "height": 131,
                            "url": "https://i.pinimg.com/170x/27/44/7d/27447ddaba3dc39dfd2b03ec8405b14b.jpg",
                            "width": 170
                        },
                        {
                            "height": 182,
                            "url": "https://i.pinimg.com/236x/27/44/7d/27447ddaba3dc39dfd2b03ec8405b14b.jpg",
                            "width": 236
                        },
                        {
                            "height": 366,
                            "url": "https://i.pinimg.com/474x/27/44/7d/27447ddaba3dc39dfd2b03ec8405b14b.jpg",
                            "width": 474
                        },
                        {
                            "height": 569,
                            "url": "https://i.pinimg.com/736x/27/44/7d/27447ddaba3dc39dfd2b03ec8405b14b.jpg",
                            "width": 736
                        }
                    ],
                        "source_id": "759489924655252187",
                            "title": "The Akatsuki",
                                "tags": {

        "topic": [

            {
                "name": "test",
                "value": ["test"]

            },
        ],

            "type": [

                {
                    "name": "test",
                    "value": ["test"]

                },
            ]
    }
}
    """.trimIndent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SubmitImageLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()
        val memeDataTest: MemeData = gson.fromJson(jsonData, MemeData::class.java)
        val mediaType = "application/json".toMediaTypeOrNull()
        val requestBody = jsonData.toRequestBody(mediaType)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val memeApi: MemeApi by lazy {
            retrofit.create(MemeApi::class.java)
        }

        memeApi.uploadImageV1(memeDataTest).enqueue(object: Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.isSuccessful){
                    Log.d("AAA", response.body().toString())
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("AAA", t.message.toString())
            }

        })
    }


}