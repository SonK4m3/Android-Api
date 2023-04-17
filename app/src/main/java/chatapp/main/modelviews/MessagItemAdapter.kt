package chatapp.main.modelviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import chatapp.main.R
import chatapp.main.models.Friend

class MessageItemAdapter(private val _friends: MutableList<Friend>?, private var _context: Context?): RecyclerView.Adapter<MessageItemAdapter.MessageViewHolder>() {

    class MessageViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        var friendName: TextView? = null
        var message: TextView? = null
        var time: TextView? = null
        var ivUnread : AppCompatImageView? = null
        var ivRead : AppCompatImageView? = null
        var ivSeen : AppCompatImageView? = null

        init {
            friendName = itemView.findViewById(R.id.tvFriendName)
            message = itemView.findViewById(R.id.tvMessage)
            time = itemView.findViewById(R.id.tvTime)
            ivUnread = itemView.findViewById(R.id.ivUnread)
            ivRead = itemView.findViewById(R.id.ivRead)
            ivSeen = itemView.findViewById(R.id.ivSeen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)
        return MessageViewHolder(inflater.inflate(R.layout.speech_item, parent, false))
        }

    override fun getItemCount(): Int = _friends!!.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val friend: Friend = _friends!![position]

        holder.friendName?.setText(friend.name.toString())
        holder.message?.setText(friend.messages!![0].content.toString())
        holder.time?.setText(friend.messages!![0].time.toString())
        when(friend!!.messages!![0].isSeen){
            0 -> {
                holder.ivUnread!!.visibility = View.VISIBLE
                holder.ivRead!!.visibility = View.GONE
                holder.ivSeen!!.visibility = View.GONE
            }

            1-> {
                holder.ivUnread!!.visibility = View.GONE
                holder.ivRead!!.visibility = View.VISIBLE
                holder.ivSeen!!.visibility = View.GONE
            }

            2 -> {
                holder.ivUnread!!.visibility = View.GONE
                holder.ivRead!!.visibility = View.GONE
                holder.ivSeen!!.visibility = View.VISIBLE
            }
        }
    }
}