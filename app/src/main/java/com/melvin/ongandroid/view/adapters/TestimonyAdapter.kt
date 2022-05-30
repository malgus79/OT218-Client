package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.databinding.FragmentTestimonyItemBinding
import com.melvin.ongandroid.model.data.testimonials.Testimonial

class TestimonyAdapter(private val dataSet: List<Testimonial>) :
    RecyclerView.Adapter<TestimonyAdapter.TestimonyViewHolder>() {

    class TestimonyViewHolder(private var binding: FragmentTestimonyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(testimonial: Testimonial) {
            //Set title
            binding.tvTestimonyName.text = testimonial.name
            //Set description
            binding.tvTestimonyDescription.text = testimonial.description
            //Load image
            Glide.with(binding.root.context)
                .load(testimonial.image)
                //.error(R.drawable.ic_contact)
                //.transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivTestimonyImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TestimonyAdapter.TestimonyViewHolder {
        return TestimonyAdapter.TestimonyViewHolder(
            FragmentTestimonyItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: TestimonyViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}