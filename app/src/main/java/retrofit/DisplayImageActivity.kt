package retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.MemeImageLayoutBinding
import meme.MemeApi
import meme.MemeApiResponse
import meme.MemeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayImageActivity: AppCompatActivity() {

    companion object {
        const val TOPIC = "topic"
    }

    private lateinit var binding: MemeImageLayoutBinding
    var bundle: Bundle? = null
    var idTopic: Int? = 21
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = MemeImageLayoutBinding.inflate(layoutInflater)
            setContentView(binding.root)

            bundle = intent.extras
            bundle?.let {
                idTopic = bundle?.getString(TOPIC)?.toInt()
            }
            val ret = RetrofitHelper.getInstance()
            val memeApi: MemeApi by lazy {
                ret.create(MemeApi::class.java)
            }

            memeApi.getMemeResponsePara(idTopic!!, 20, 15).enqueue(object : Callback<MemeApiResponse> {
                override fun onResponse(
                    call: Call<MemeApiResponse>,
                    response: Response<MemeApiResponse>
                ) {
                    if(response.isSuccessful){
                        val data: ArrayList<MemeData> = response.body()!!.data
                        binding.recyclerview.adapter = ImageAdpater(data)
                        binding.recyclerview.layoutManager = GridLayoutManager(baseContext, 3)
                    }
                }

                override fun onFailure(call: Call<MemeApiResponse>, t: Throwable) {
                    Toast.makeText(this@DisplayImageActivity, "$t.message", Toast.LENGTH_SHORT).show()
                }

            })
    }
}