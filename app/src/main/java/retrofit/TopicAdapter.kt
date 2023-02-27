package retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TopicAdapter(private var topics: List<Topic>?, private var mContext: Context?): RecyclerView.Adapter<TopicAdapter.TopicVH>() {

    class TopicVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val topicView: View
        var nametopic: TextView
        var idtopic: TextView

        init {
            topicView = itemView
            nametopic = itemView.findViewById(R.id.nameTopic)
            idtopic = itemView.findViewById(R.id.idTopic)
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