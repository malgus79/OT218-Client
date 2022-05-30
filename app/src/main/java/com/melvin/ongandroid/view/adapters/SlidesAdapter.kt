package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.SlidesListItemBinding
import com.melvin.ongandroid.model.data.slides.Slide

class SlidesAdapter (private val dataSet: List<Slide>, private val isHome: Boolean) :
    RecyclerView.Adapter<SlidesAdapter.SlideViewHolder>() {

    private val homeDataSet = dataSet.take(4)

    class SlideViewHolder(private var binding: SlidesListItemBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bind(slide: Slide){
                //Set title
                binding.tvSlideTitle.text = slide.name
                //Set description
                binding.tvActivityDescription.text = slide.description
                //Load image
                Glide.with(binding.root.context)
                    .load(slide.imageSlide)
                    .error(R.drawable.ic_contact) //ic_baseline_broken_image_24
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.ivSlideImage)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val binding = SlidesListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SlideViewHolder(binding)
    }


    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        if (isHome)
            return homeDataSet.size

        return  dataSet.size
    }


}

