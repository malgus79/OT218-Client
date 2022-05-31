package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentTestimonyItemBinding
import com.melvin.ongandroid.model.data.testimonials.Testimonial

class TestimonialsAdapter(private val dataSet: List<Testimonial>, private val isHome: Boolean) :
    RecyclerView.Adapter<TestimonialsAdapter.TestimonialsViewHolder>() {

    private val homeDataSet = dataSet.take(4)

    class TestimonialsViewHolder(private var binding: FragmentTestimonyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(testimonial: Testimonial) {
            //Set name
            binding.tvTestimonyName.text = testimonial.name
            //Set description
            binding.tvTestimonyDescription.text = testimonial.description
            //Load image
            Glide.with(binding.root.context)
                .load(testimonial.image)
                .error(R.drawable.ic_contact) //ic_baseline_broken_image_24
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivTestimonyImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonialsViewHolder {
        val binding = FragmentTestimonyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TestimonialsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TestimonialsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        if (isHome)
            return homeDataSet.size

        return  dataSet.size
    }
}