package viewpager2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFragmentStateAdapter(fm: FragmentManager, lc: Lifecycle): FragmentStateAdapter(fm, lc) {

    companion object {
        val COLOR = "color"
        val POSITION = "position"
    }

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        if(position == 4) return com.example.myapplication.Fragment1()

        return PagerFragment().apply {
            arguments = Bundle().apply {
                putInt(COLOR, colors[position])
                putInt(POSITION, position)
            }
        }
    }
}