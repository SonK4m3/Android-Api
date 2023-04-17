package chatapp.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import chatapp.main.databinding.SpeechLayoutBinding
import chatapp.main.models.Friend
import chatapp.main.modelviews.FriendItemAdapter
import chatapp.main.modelviews.MessageItemAdapter

class SpeechFragment: Fragment() {
    lateinit var binding: SpeechLayoutBinding
    private var friends: ArrayList<Friend>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SpeechLayoutBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friends = ArrayList()
        friends!!.add(Friend(0,"Unknown", "url"))
        for(i in 1..6){
            friends!!.add(Friend(i,"Son Nguyen Hong", "url"))
        }

        var linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        binding.friendList.adapter = FriendItemAdapter(friends, context)
        binding.friendList.layoutManager = linearLayoutManager

        binding.messageList.adapter = MessageItemAdapter(friends, context)
        binding.messageList.layoutManager = LinearLayoutManager(context)
    }

    companion object {
        fun newInstance() = SpeechFragment().apply {
            arguments = Bundle().apply {
                //TODO(send data)
            }
        }
    }
}