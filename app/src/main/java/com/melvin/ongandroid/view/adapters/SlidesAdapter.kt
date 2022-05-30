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
class SlidesAdapter (private val dataSet: List<Slide>) : RecyclerView.Adapter<SlidesAdapter.SlidesViewHolder>() {

    class SlidesViewHolder(private var binding: SlidesListItemBinding):
=======
class SlidesAdapter (private val dataSet: List<Slide>) : RecyclerView.Adapter<SlidesAdapter.TestimonyViewHolder>() {

    class TestimonyViewHolder(private var binding: SlidesListItemBinding):
>>>>>>> 5e4589c (Testimony fragment added)
=======
=======
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
class SlidesAdapter (private val dataSet: List<Slide>, private val isHome: Boolean) :
    RecyclerView.Adapter<SlidesAdapter.SlideViewHolder>() {

    private val homeDataSet = dataSet.take(4)

    class SlideViewHolder(private var binding: SlidesListItemBinding):
<<<<<<< HEAD
>>>>>>> 08a6025 (slider compiling)
=======
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlidesViewHolder {
        return SlidesViewHolder(
=======
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonyViewHolder {
        return TestimonyViewHolder(
>>>>>>> 5e4589c (Testimony fragment added)
            SlidesListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
=======
=======
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val binding = SlidesListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
<<<<<<< HEAD
>>>>>>> 08a6025 (slider compiling)
=======
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
        )
        return SlideViewHolder(binding)
    }

<<<<<<< HEAD
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

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        if (isHome)
            return homeDataSet.size

        return  dataSet.size
    }


}

