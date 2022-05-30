package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.SlidesListItemBinding
import com.melvin.ongandroid.model.data.slides.Slide

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
class SlidesAdapter(private val dataSet: List<Slide>) :
    RecyclerView.Adapter<SlidesAdapter.SlidesViewHolder>() {

    class SlidesViewHolder(private var binding: SlidesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(slide: Slide) {
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
=======
=======
>>>>>>> a53495d (slider compiling)
<<<<<<< HEAD
class SlidesAdapter (private val dataSet: List<Slide>) : RecyclerView.Adapter<SlidesAdapter.SlidesViewHolder>() {

    class SlidesViewHolder(private var binding: SlidesListItemBinding):
=======
class SlidesAdapter (private val dataSet: List<Slide>) : RecyclerView.Adapter<SlidesAdapter.TestimonyViewHolder>() {

    class TestimonyViewHolder(private var binding: SlidesListItemBinding):
>>>>>>> 5e4589c (Testimony fragment added)
=======
class SlidesAdapter (private val dataSet: List<Slide>, private val isHome: Boolean) :
    RecyclerView.Adapter<SlidesAdapter.SlideViewHolder>() {

    private val homeDataSet = dataSet.take(4)

    class SlideViewHolder(private var binding: SlidesListItemBinding):
>>>>>>> 08a6025 (slider compiling)
=======
class SlidesAdapter (private val dataSet: List<Slide>) : RecyclerView.Adapter<SlidesAdapter.TestimonyViewHolder>() {

    class TestimonyViewHolder(private var binding: SlidesListItemBinding):
>>>>>>> 5e4589c (Testimony fragment added)
        RecyclerView.ViewHolder(binding.root){

            fun bind(slide: Slide){
                //Set title
                binding.tvSlideTitle.text = slide.name
                //Set description
                binding.tvActivityDescription.text = slide.description
                //Load image
                Glide.with(binding.root.context)
                    .load(slide.imageSlide)
<<<<<<< HEAD
                    .error(R.drawable.ic_contact) //ic_baseline_broken_image_24
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.ivSlideImage)
            }
>>>>>>> dd3c420 (Testimony fragment added)
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlidesViewHolder {
        return SlidesViewHolder(
=======
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonyViewHolder {
        return TestimonyViewHolder(
>>>>>>> 5e4589c (Testimony fragment added)
=======
                    //.error(R.drawable.ic_baseline_broken_image_100)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.ivSlideImage)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonyViewHolder {
        return TestimonyViewHolder(
>>>>>>> 5e4589c (Testimony fragment added)
            SlidesListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
<<<<<<< HEAD
=======
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val binding = SlidesListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
>>>>>>> 08a6025 (slider compiling)
        )
        return SlideViewHolder(binding)
    }

<<<<<<< HEAD
<<<<<<< HEAD
    override fun onBindViewHolder(holder: SlidesViewHolder, position: Int) {
=======
    override fun onBindViewHolder(holder: TestimonyViewHolder, position: Int) {
>>>>>>> 5e4589c (Testimony fragment added)
=======

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
>>>>>>> 08a6025 (slider compiling)
=======
        )
    }

    override fun onBindViewHolder(holder: TestimonyViewHolder, position: Int) {
>>>>>>> 5e4589c (Testimony fragment added)
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
<<<<<<< HEAD
<<<<<<< HEAD
        return dataSet.size
=======
        if (isHome)
            return homeDataSet.size

        return  dataSet.size
>>>>>>> a53495d (slider compiling)
=======
      return  dataSet.size
>>>>>>> 5e4589c (Testimony fragment added)
    }


}

