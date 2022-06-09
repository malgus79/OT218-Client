package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsItemBinding
import com.melvin.ongandroid.model.data.news.New


class NewsViewPagerAdapter(private val newsList: List<New>) :
    RecyclerView.Adapter<NewsViewPagerAdapter.ViewPagerViewHolder>() {
    private val data = newsList.take(4)

    class ViewPagerViewHolder(private val binding: FragmentNewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(new: New) {
            //Set title
            binding.tvNewName.text = new.name
            //Set description
            binding.tvNewDesc.text = new.content
            //Load image
            Glide.with(binding.root.context)
                .load(new.image)
                .error(R.drawable.ic_home) // ic_baseline_broken_image_100 not found
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivNewsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = FragmentNewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}