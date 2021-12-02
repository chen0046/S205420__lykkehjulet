package com.example.s205420__lykkehjulet.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s205420__lykkehjulet.R
import org.w3c.dom.Text

class RecycleAdapter: RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    private var title = arrayOf("1 Player","2 Player", "3 Player", "4 Player")
    private var detail = arrayOf("Play as 1", "Plays as 2", "Play as 3", "Play as 4")
    private var images = intArrayOf(R.drawable.player1,R.drawable.player2,R.drawable.player3,R.drawable.player4)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.categori_layout,parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetail.text = detail[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return title.size

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init{
            itemImage = itemView.findViewById(R.id.image)
            itemTitle = itemView.findViewById(R.id.title)
            itemDetail = itemView.findViewById(R.id.detail)
        }
    }


}