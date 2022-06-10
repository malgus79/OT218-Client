package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentMembersItemBinding
import com.melvin.ongandroid.model.data.Member

class MembersAdapter (private val membersList: List<Member>) :
 RecyclerView.Adapter<MembersAdapter.MemberViewHolder>(){

     class MemberViewHolder(private val binding: FragmentMembersItemBinding) :
             RecyclerView.ViewHolder(binding.root){

                 fun setData(member: Member){
                     //Set name
                     binding.tvMemberName.text = member.name
                     //Set description
                     binding.tvMemberDescription.text = member.description
                     //Load image
                     Glide.with(binding.root.context)
                         .load(member.image)
                         .error(R.drawable.ic_baseline_broken_image_24)
                         .transition(DrawableTransitionOptions.withCrossFade())
                         .into(binding.ivMemberPic)
                 }
             }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val binding = FragmentMembersItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.setData(membersList[position])
    }

    override fun getItemCount(): Int {
        return membersList.size
    }
}