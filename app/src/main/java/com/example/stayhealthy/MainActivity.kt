package com.example.stayhealthy

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // System stuff
        supportActionBar?.hide()
        enableEdgeToEdge()

        // Setup the NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        //Setup bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        // Look for changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> bottomNavigationView.visibility = View.GONE
                R.id.homeFragment -> bottomNavigationView.visibility = View.VISIBLE
                R.id.gymsFragment -> bottomNavigationView.visibility = View.VISIBLE
                R.id.spasFragment -> bottomNavigationView.visibility = View.VISIBLE
                else -> bottomNavigationView.visibility = View.VISIBLE
            }
        }
        // Move around
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_gyms -> {
                    loadFragment(GymsFragment())
                    true
                }
                R.id.navigation_spas -> {
                    loadFragment(SpasFragment())
                    true
                }
                else -> false
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController.navigateUp() || super.onSupportNavigateUp()
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.nav_host_fragment, fragment)
        }
    }

}
