package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.firebase.analytics.FirebaseAnalytics
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentMembersDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MembersFragmentDetail : Fragment(R.layout.fragment_members_detail) {

    private lateinit var binding: FragmentMembersDetailBinding
    private val args by navArgs<MembersFragmentDetailArgs>()
    private lateinit var analytics: FirebaseAnalytics

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMembersDetailBinding.bind(view)
        Glide.with(requireContext()).load(args.image).centerCrop().into(binding.tvDetailImage)
        binding.tvDetailName.text = args.name
        binding.tvDetailDescriptions.text = args.description
        binding.memberDetailFacebook.text = args.linkFacebook
        binding.memberDetailLinkedin.text = args.linkLinkedin

        //Success Analytics Event
        val bundle = Bundle()
        bundle.putString("message", "member_pressed")
        analytics.logEvent("member_pressed", bundle)

    }
}