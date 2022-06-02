package com.melvin.ongandroid.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.ActivityMainBinding
import com.melvin.ongandroid.databinding.ActivityNavigationBinding
import com.melvin.ongandroid.view.fragment.ContactFragment
import com.melvin.ongandroid.view.fragment.HomeFragment
import com.melvin.ongandroid.view.fragment.OurActivitiesFragment
import com.melvin.ongandroid.view.fragment.StaffFragment
import com.melvin.ongandroid.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var activeFragment: Fragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Show Spinner Loading
        //viewModel.isShowProgress()

        //Add the fragments to the nav menu
        // setupBottomNav()
        //viewModel.isShowProgress()
        binding.button.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

    }

    private fun setupBottomNav() {
        //Initialize Fragment Manager
        fragmentManager = supportFragmentManager

        //Instantiate fragments
        val homeFragment = HomeFragment()
        val staffFragment = StaffFragment()
        val ourActivitiesFragment = OurActivitiesFragment()
        val contactFragment = ContactFragment()

        //Initialize Fragment Home
        activeFragment = homeFragment

        //Add fragment Contact
        fragmentManager.beginTransaction()
            .add(R.id.navHostFragment, contactFragment, ContactFragment::class.java.name)
            .hide(contactFragment).commit()

        //Add fragment OurActivities
        fragmentManager.beginTransaction()
            .add(R.id.navHostFragment, ourActivitiesFragment, OurActivitiesFragment::class.java.name)
            .hide(ourActivitiesFragment).commit()

        //Add fragment Staff
        fragmentManager.beginTransaction()
            .add(R.id.navHostFragment, staffFragment, StaffFragment::class.java.name)
            .hide(staffFragment).commit()

        //Add fragment Home
        fragmentManager.beginTransaction()
            .add(R.id.navHostFragment, homeFragment, HomeFragment::class.java.name)
            .commit()

        //Navigate to the different fragments
//        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_home -> {
//                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
//                    activeFragment = homeFragment
//                    true
//                }
//                R.id.nav_staff -> {
//                    fragmentManager.beginTransaction().hide(activeFragment).show(staffFragment).commit()
//                    activeFragment = staffFragment
//                    true
//                }
//                R.id.nav_our_activities -> {
//                    fragmentManager.beginTransaction().hide(activeFragment).show(ourActivitiesFragment).commit()
//                    activeFragment = ourActivitiesFragment
//                    true
//                }
//                R.id.nav_contact -> {
//                    fragmentManager.beginTransaction().hide(activeFragment).show(contactFragment).commit()
//                    activeFragment = contactFragment
//                    true
//                }
//                else -> false
//            }
//        }
    }
}