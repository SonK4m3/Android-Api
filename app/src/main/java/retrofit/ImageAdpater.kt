package retrofit

import android.view.*
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import meme.Images
import meme.MemeData

class ImageAdpater(val datas: ArrayList<MemeData>?): RecyclerView.Adapter<ImageAdpater.ImageVH>() {
    class ImageVH(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var iv: View
        lateinit var img: ImageView
        init {
            iv = itemView
            img = itemView.findViewById(R.id.imageItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        return ImageVH(LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return datas!!.size
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        val memeData: MemeData = datas!!.get(position)
        val image: Images = memeData.images.get(1)

        Picasso.get().load(image.url).into(holder.img)
    }
}