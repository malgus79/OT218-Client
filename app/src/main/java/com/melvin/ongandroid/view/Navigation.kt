package com.melvin.ongandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.melvin.ongandroid.R

class Navigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val newsFragment =NewsFragment()

        bottomNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_home -> {
                    Toast.makeText(this,"Inicio", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_staff -> {
                    Toast.makeText(this,"Staff", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_news -> {
                    setCurrentFragment(newsFragment)
                    Toast.makeText(this,"Novedades", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_contribute -> {
                    Toast.makeText(this,"Contribuir", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_contact -> {
                    Toast.makeText(this,"Contacto", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }

    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit()
        }
    }
}