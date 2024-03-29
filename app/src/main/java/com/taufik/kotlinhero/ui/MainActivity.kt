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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setNavHost()
        setUpNavigationDestination()
    }

    private fun setNavHost() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.findNavController()

        binding.apply {
            navController?.let { navBottom.setupWithNavController(it) }
        }
    }

    private fun setUpNavigationDestination() {
        navController?.addOnDestinationChangedListener {_, destination, _ ->
            when (destination.id) {
                R.id.kotlinBasicFragment -> isShowBottomNavigation(false)
                else -> isShowBottomNavigation(true)
            }
        }
    }

    private fun isShowBottomNavigation(isShow: Boolean) {
        binding.navBottom.visibility = if (isShow) View.VISIBLE else View.GONE
    }
}