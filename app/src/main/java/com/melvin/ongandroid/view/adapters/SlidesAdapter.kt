package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.SlidesListItemBinding
import com.melvin.ongandroid.model.data.slides.Slide

class SlidesAdapter (private val dataSet: List<Slide>) : RecyclerView.Adapter<SlidesAdapter.SlidesViewHolder>() {

    class SlidesViewHolder(private var binding: SlidesListItemBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bind(slide: Slide){
                //Set title
                binding.tvSlideTitle.text = slide.name
                //Set description
                binding.tvActivityDescription.text = slide.description
                //Load image
                Glide.with(binding.root.context)
                    .load(slide.imageSlide)
                    .error(R.drawable.ic_home) // ic_baseline_broken_image_100 not found
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.ivSlideImage)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlidesViewHolder {
        return SlidesViewHolder(
            SlidesListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: SlidesViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
      return  dataSet.size
    }


}

