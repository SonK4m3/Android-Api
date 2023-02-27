package retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.RetrofitLayoutBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity: AppCompatActivity() {
    private lateinit var binding: RetrofitLayoutBinding

    var testList : List<Topic>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RetrofitLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ret = RetrofitHelper.getInstance()
        val topicsApi: TopicApi by lazy {
            ret.create(TopicApi::class.java)
        }

        topicsApi.getTopics().enqueue(object : Callback<TopicList> {
            override fun onResponse(call: Call<TopicList>, response: Response<TopicList>) {
                if(response.isSuccessful) {
                    var resultTopic: List<Topic> = response.body()!!.listTopic
                    //sort by id
                    resultTopic = resultTopic.sortedBy { it.id }
                    binding.recyclerview.adapter = TopicAdapter(resultTopic, baseContext)
                    binding.recyclerview.layoutManager = LinearLayoutManager(baseContext)
                }
            }

            override fun onFailure(call: Call<TopicList>, t: Throwable) {
                Toast.makeText(this@RetrofitActivity, "$t.message", Toast.LENGTH_SHORT).show()
            }
        })
    }
}