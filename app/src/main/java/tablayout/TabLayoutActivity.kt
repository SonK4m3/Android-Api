package tablayout

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.TablayoutLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity: AppCompatActivity() {
    private lateinit var binding: TablayoutLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TablayoutLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TabLayoutPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "First"
                1 -> tab.text = "Second"
                else -> tab.text = "Third"
            }
        }.attach()
    }
}