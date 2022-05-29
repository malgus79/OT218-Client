package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.CardActivitiesLayoutBinding
import com.melvin.ongandroid.databinding.FragmentOurActivitiesBinding
import com.melvin.ongandroid.model.data.activities.Activities
import com.melvin.ongandroid.model.data.news.New

class ActivitiesAdapter (private val newsList: List<Activities>) :
    RecyclerView.Adapter<ActivitiesAdapter.ViewPagerViewHolder>() {
    private val data = newsList.shuffled().take(4)

    class ViewPagerViewHolder(private val binding: CardActivitiesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(new: Activities) {
            //Set title
            binding.tvActivities.text = new.name
            //Set description
            binding.tvActivitiesDesc.text = new.description
            //Load image
            Glide.with(binding.root.context)
                .load(new.image)
                .error(R.drawable.voluntario_pobreza) // (test image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivActivities)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = CardActivitiesLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setData(data[position])
    }


}