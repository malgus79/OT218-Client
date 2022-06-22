package com.melvin.ongandroid.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentMembersItemBinding
import com.melvin.ongandroid.model.data.Member
import com.melvin.ongandroid.utils.convertHtmlToString
import com.melvin.ongandroid.view.fragment.MembersFragmentDirections

class MembersAdapter(private val membersList: List<Member>) :
    RecyclerView.Adapter<MembersAdapter.MemberViewHolder>() {

    class MemberViewHolder(private val binding: FragmentMembersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(member: Member) {
            //Set name
            binding.tvMemberName.text = member.name
            //Set description
            binding.tvMemberDescription.text = member.description.convertHtmlToString().trim()
            //Load image
            Glide.with(binding.root.context)
                .load(member.image)
                .error(R.drawable.ic_baseline_broken_image_24)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivMemberPic)

            binding.cvMemberItem.setOnClickListener {
//                    view ->
//                view.findNavController().navigate(R.id.action_nav_members_to_membersFragmentDetail)

                val action = MembersFragmentDirections.actionNavMembersToMembersFragmentDetail(
                    member.image.toString(),
                    member.name.toString(),
                    member.description.toString(),
                    member.facebookUrl.toString(),
                    member.linkedinUrl.toString()
                )
                this.itemView.findNavController().navigate(action)
            }
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