package chatapp.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import chatapp.main.databinding.StoryLayoutBinding

class StoryFragment: Fragment() {

    lateinit var binding: StoryLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StoryLayoutBinding.inflate(inflater, container, false)



        return binding.root
    }

}