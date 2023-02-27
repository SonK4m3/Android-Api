package tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import viewpager2.ViewPagerFragmentStateAdapter

class TabLayoutPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

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
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return viewpager2.PagerFragment().apply {
            arguments = Bundle().apply {
                putInt(ViewPagerFragmentStateAdapter.COLOR, colors[position])
                putInt(ViewPagerFragmentStateAdapter.POSITION, position)
            }
        }
    }


}