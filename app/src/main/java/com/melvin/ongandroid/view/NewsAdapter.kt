package com.melvin.ongandroid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.NewsViewBinding
import com.melvin.ongandroid.model.Novedades

class NewsAdapter(private val newsList: List<Novedades>) :
    RecyclerView.Adapter<NewsAdapter.NovedadesViewHolder>() {

    class NovedadesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = NewsViewBinding.bind(itemView)

        fun bind(novedades: Novedades) {
            binding.newsImageView.setImageResource(novedades.newImage)
            binding.newsTitle.text = novedades.newName
            binding.newsDescription.text = novedades.newDescription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovedadesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_view, parent, false)
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