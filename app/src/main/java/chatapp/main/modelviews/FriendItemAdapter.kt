package chatapp.main.modelviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import chatapp.main.R
import chatapp.main.models.Friend

class FriendItemAdapter(private val _friends: MutableList<Friend>?, private var _context: Context?): RecyclerView.Adapter<FriendItemAdapter.FriendViewHolder>() {

    val UPDATE_STATE = 0
    val FRIEND_ITEM = 1

    class FriendViewHolder(var itemView: View): ViewHolder(itemView){
        var friendName: TextView? = null

        init {
            friendName = itemView.findViewById(R.id.friend_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val context: Context = parent.context
        val inflater: LayoutInflater = LayoutInflater.from(context)
        return when(viewType){
            UPDATE_STATE -> {
                FriendViewHolder(inflater.inflate(R.layout.update_state_item, parent, false))
            }
            else -> {
                FriendViewHolder(inflater.inflate(R.layout.friend_item, parent, false))
            }
        }
    }

    override fun getItemCount(): Int = _friends!!.size

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) UPDATE_STATE else FRIEND_ITEM
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friend: Friend = _friends!![position]

        holder.friendName?.setText(friend.name.toString())
    }
}