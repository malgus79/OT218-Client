package com.melvin.ongandroid.view

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.ActivityLoginBinding
import com.melvin.ongandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        //Bottom Navigation
        binding.bottomNavigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_menu, menu)
        return true
    }

//    Este codigo no es necesario, pues ya en navigation activity se hace con muchas menos lineas de codigo
//    private fun setupBottomNav() {
//        //Initialize Fragment Manager
//        fragmentManager = supportFragmentManager
//
//        //Instantiate fragments
//        val homeFragment = HomeFragment()
//        val membersFragment = MembersFragment()
//        val ourActivitiesFragment = OurActivitiesFragment()
//        val contactFragment = ContactFragment()
//
//        //Initialize Fragment Home
//        activeFragment = homeFragment
//
//        //Add fragment Contact
//        fragmentManager.beginTransaction()
//            .add(R.id.navHostFragment, contactFragment, ContactFragment::class.java.name)
//            .hide(contactFragment).commit()
//
//        //Add fragment OurActivities
//        fragmentManager.beginTransaction()
//            .add(R.id.navHostFragment, ourActivitiesFragment, OurActivitiesFragment::class.java.name)
//            .hide(ourActivitiesFragment).commit()
//
//        //Add fragment Staff
//        fragmentManager.beginTransaction()
//            .add(R.id.navHostFragment, membersFragment, MembersFragment::class.java.name)
//            .hide(membersFragment).commit()
//
//        //Add fragment Home
//        fragmentManager.beginTransaction()
//            .add(R.id.navHostFragment, homeFragment, HomeFragment::class.java.name)
//            .commit()
//
//        //Navigate to the different fragments
//        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_home -> {
//                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
//                    activeFragment = homeFragment
//                    true
//                }
//                R.id.nav_members -> {
//                    fragmentManager.beginTransaction().hide(activeFragment).show(membersFragment).commit()
//                    activeFragment = membersFragment
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
//    }
}