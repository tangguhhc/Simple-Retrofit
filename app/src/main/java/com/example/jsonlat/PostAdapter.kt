package com.example.jsonlat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter (private val list: ArrayList<PostResponse>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val tvText: TextView = itemView.findViewById(R.id.tvText)
        fun bind(postResponse : PostResponse){
            val text = "id: ${postResponse.id}\n" +
                    "title: ${postResponse.title}\n" +
                    "text: ${postResponse.text}"

            tvText.text = text
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false )
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.bind(list[position])
    }
}