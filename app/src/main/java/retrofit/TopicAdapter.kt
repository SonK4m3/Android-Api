package retrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TopicAdapter(private var topics: List<Topic>?, private var mContext: Context?): RecyclerView.Adapter<TopicAdapter.TopicVH>() {

    companion object {
        const val TOPIC = "topic"
    }

    class TopicVH(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val topicView: View
        var nametopic: TextView
        var idtopic: TextView

        init {
            topicView = itemView
            nametopic = itemView.findViewById(R.id.nameTopic)
            idtopic = itemView.findViewById(R.id.idTopic)
            itemView.setOnClickListener(this)
        }

        override fun onClick(item: View?) {
            Toast.makeText(itemView.context, nametopic.text, Toast.LENGTH_SHORT).show()
            val goToImageActivity = Intent(itemView.context, DisplayImageActivity::class.java)
            goToImageActivity.putExtra(TOPIC, idtopic.text)
            itemView.context.startActivity(goToImageActivity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicVH {
        return TopicVH(LayoutInflater.from(parent.context).inflate(R.layout.topic_item, parent, false))
    }

    override fun getItemCount(): Int {
        return topics!!.size

    }

    override fun onBindViewHolder(holder: TopicVH, position: Int) {
        val tp: Topic? = topics!!.get(position)
        holder.nametopic.setText(tp!!.name)
        holder.idtopic.setText(tp!!.id.toString())
    }
}