package com.melvin.ongandroid.view.fragment
// TODO
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import com.melvin.ongandroid.databinding.FragmentMembersBinding
//import com.melvin.ongandroid.databinding.FragmentMembersDetailBinding
//import com.melvin.ongandroid.viewmodel.MembersViewModel
//
//class MemberDetailFragment : Fragment() {
//
//    private val viewModel by viewModels<MembersViewModel>()
//    private lateinit var binding: FragmentMembersDetailBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentMembersDetailBinding.inflate(inflater, container, false)
//
//        binding.memberDetailFacebook.setOnClickListener {
//            val facebookUrl: String = "facebookUrl"
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse(facebookUrl)
//            startActivity(intent)
//        }
//        return binding.root
//    }
//}