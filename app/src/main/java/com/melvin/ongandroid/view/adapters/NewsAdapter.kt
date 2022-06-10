package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsItemBinding
import com.melvin.ongandroid.databinding.LastNewsItemBinding
import com.melvin.ongandroid.model.data.news.New

class NewsAdapter(private val newsList: List<New>) :
    RecyclerView.Adapter<NewsAdapter.RecyclerViewHolder>() {


    class RecyclerViewHolder(private val binding: LastNewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(activity: New) {
            //Set title
            binding.tvNewName.text = activity.name
            //Set description
            binding.tvNewDesc.text = activity.toString()
            //Load image
            Glide.with(binding.root.context)
                .load(activity.image)
                .error(R.drawable.ic_baseline_broken_image_100)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivNewsImage)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = LastNewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.setData(newsList[position])
    }

}