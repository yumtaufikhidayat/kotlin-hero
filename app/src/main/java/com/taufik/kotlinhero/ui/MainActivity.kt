package com.taufik.kotlinhero.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setNavHost()
        setUpNavigationDestination()
    }

    private fun setNavHost() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.findNavController()

        binding.apply {
            navBottom.setupWithNavController(navController)
        }
    }

    private fun setUpNavigationDestination() {
        navController.addOnDestinationChangedListener {_, destination, _ ->
            when (destination.id) {
                R.id.kotlinBasicFragment -> hideBottomNavigation()
                R.id.kotlinOOPFragment -> hideBottomNavigation()
                R.id.kotlinGenericFragment -> hideBottomNavigation()
                R.id.kotlinCollectionFragment -> hideBottomNavigation()
                R.id.kotlinCoroutineFragment -> hideBottomNavigation()
                else -> showBottomNavigation()
            }
        }
    }

    private fun showBottomNavigation() {
        binding.apply {
            navBottom.visibility = View.VISIBLE
        }
    }

    private fun hideBottomNavigation() {
        binding.apply {
            navBottom.visibility = View.GONE
        }
    }
}