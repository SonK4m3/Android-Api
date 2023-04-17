package chatapp.main.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import chatapp.main.databinding.MainActivityLayoutBinding
import chatapp.main.fragments.ContactFragment
import chatapp.main.fragments.SpeechFragment
import chatapp.main.fragments.StoryFragment
import chatapp.main.fragments.VideoCallFragment
import chatapp.main.modelviews.TabLayoutAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity: AppCompatActivity() {

    lateinit var binding: MainActivityLayoutBinding
    lateinit var fragments: ArrayList<Fragment>
    private var tablayouAdapter: TabLayoutAdapter? = null
    private val titles: Array<String> = arrayOf(
        "Đoạn chat", "Cuộc gọi", "Danh bạ", "Tin"
    )

    private val SPEECH_FRAGMENT_ID = 0;
    private val VIDEO_CALL_FRAGMENT_ID = 1;
    private val CONTACT_FRAGMENT_ID = 2;
    private val STORY_FRAGMENT_ID = 3;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 1.
        initializeFragments();
        // 2.
        tablayouAdapter = TabLayoutAdapter(fragments, supportFragmentManager, lifecycle)
        binding.viewpager.adapter = tablayouAdapter
        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                binding.title.setText(titles[position])
                binding.cameraIc.visibility = View.GONE
                binding.editIc.visibility = View.GONE
                binding.phoneIc.visibility = View.GONE
                binding.videoCallIc.visibility = View.GONE
                binding.contactIc.visibility = View.GONE

                when(position){
                    SPEECH_FRAGMENT_ID -> {
                        binding.cameraIc.visibility = View.VISIBLE
                        binding.editIc.visibility = View.VISIBLE
                    }
                    VIDEO_CALL_FRAGMENT_ID -> {
                        binding.phoneIc.visibility = View.VISIBLE
                        binding.videoCallIc.visibility = View.VISIBLE
                    }
                    CONTACT_FRAGMENT_ID -> {
                        binding.contactIc.visibility = View.VISIBLE
                    }
                    else -> {

                    }
                }
            }
        })

        TabLayoutMediator(binding.tabLayout, binding.viewpager) {
            tab, position -> apply {
                tab.text = titles[position]
            }
        }.attach()

//        binding.tabLayout.clearOnTabSelectedListeners()
    }

    fun initializeFragments(){
        fragments = ArrayList()
        fragments.add(SpeechFragment())
        fragments.add(VideoCallFragment())
        fragments.add(ContactFragment())
        fragments.add(StoryFragment())
    }
}