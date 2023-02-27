package retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.RetrofitLayoutBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity: AppCompatActivity() {
    private lateinit var binding: RetrofitLayoutBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RetrofitLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topicsApi = RetrofitHelper.getInstance().create(TopicApi::class.java)
        topicsApi.getTopics().enqueue(object : Callback<TopicList> {
            override fun onResponse(call: Call<TopicList>, response: Response<TopicList>) {
                Log.d("AAA", response.body().toString())
            }

            override fun onFailure(call: Call<TopicList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


        // launching a new coroutine
//        GlobalScope.launch {
//            val result = topicsApi.getTopics()
//            if (result != null)
//            // Checking the results
//                Log.d("cayuse: ", )
//        }
    }
}