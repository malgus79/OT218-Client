package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.CardActivitiesLayoutBinding
import com.melvin.ongandroid.model.data.activities.Activity


class ActivitiesAdapter (private val activitiesList: List<Activity>) :
    RecyclerView.Adapter<ActivitiesAdapter.ViewPagerViewHolder>() {


    class ViewPagerViewHolder(private val binding: CardActivitiesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(activity: Activity) {
            //Set title
            binding.tvActivities.text = activity.name
            //Set description
            binding.tvActivitiesDesc.text = activity.description
            //Load image
            Glide.with(binding.root.context)
                .load(activity.image)
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
        return activitiesList.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setData(activitiesList[position])
    }


}