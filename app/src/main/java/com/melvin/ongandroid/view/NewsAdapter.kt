package com.melvin.ongandroid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.databinding.NewsViewBinding

class NewsAdapter(private val newsList: List<Novedades>):
    RecyclerView.Adapter<NewsAdapter.NovedadesViewHolder>() {


    class NovedadesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = NewsViewBinding.bind(itemView)

        fun bind(novedades: Novedades) {
            binding.newsImageView.setImageResource(novedades.newImage)
            binding.newsTitle.text = novedades.newName
            binding.newsDescription.text = novedades.newDescription
        }

       // val novedadImageview: ImageView = itemView.findViewById(R.id.newsImageView)
       // val novedadTextViewTitle: TextView = itemView.findViewById(R.id.newsTitle)
       // val novedadTextViewDescription: TextView = itemView.findViewById(R.id.newsDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovedadesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_news, parent, false)
        return NovedadesViewHolder(view)
    }
    override fun onBindViewHolder(holder: NovedadesViewHolder, position: Int) {

        val novedades = newsList[position]
        holder.bind(novedades)

    }
    override fun getItemCount(): Int {

        return newsList.size
    }

}