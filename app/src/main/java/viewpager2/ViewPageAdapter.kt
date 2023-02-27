package viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ViewPageAdapter: RecyclerView.Adapter<ViewPageAdapter.PagerVH>() {
//    private lateinit  var binding: ItemLayoutBinding

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
//        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return PagerVH(binding.root)
        return PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int = colors.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
//            binding.tvTitle.text = "item $position"
//            binding.container.setBackgroundResource(colors[position])
            var tv = findViewById<AppCompatTextView>(R.id.tvTitle)
            var container = findViewById<RelativeLayout>(R.id.container)
            tv.text = "item $position"
            container.setBackgroundResource(colors[position])
        }

}