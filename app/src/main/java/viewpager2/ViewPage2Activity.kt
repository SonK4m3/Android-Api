package viewpager2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.Viewpage2LayoutBinding

class ViewPage2Activity:AppCompatActivity() {

    private lateinit var binding: Viewpage2LayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Viewpage2LayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        binding.viewPager2.adapter = ViewPageAdapter()
        binding.viewPager2.adapter = ViewPagerFragmentStateAdapter(supportFragmentManager, lifecycle)
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Toast.makeText(view.context, "this is item $position", Toast.LENGTH_SHORT).show()
            }
        })
//        setContentView(R.layout.viewpage2_layout)
//        var vp2 = findViewById<ViewPager2>(R.id.viewPager2)
//        vp2.adapter = ViewPageAdapter()
    }
}