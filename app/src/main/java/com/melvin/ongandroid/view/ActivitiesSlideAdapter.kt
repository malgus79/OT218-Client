package com.melvin.ongandroid.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.databinding.ActivitiesListItemBinding
import com.melvin.ongandroid.model.data.ListSlide

class ActivitiesSlideAdapter ( private val dataSet: List<ListSlide>) : RecyclerView.Adapter<ActivitiesSlideAdapter.ActivitiesViewHolder>() {

    class ActivitiesViewHolder(private var binding: ActivitiesListItemBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bind(activity: ListSlide){
                binding.tvActivityTitle.text = activity.name
                binding.tvActivityDescription.text = activity.description
                //TODO add image binding
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        return ActivitiesSlideAdapter.ActivitiesViewHolder(
            ActivitiesListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
      return  dataSet.size
    }


}

