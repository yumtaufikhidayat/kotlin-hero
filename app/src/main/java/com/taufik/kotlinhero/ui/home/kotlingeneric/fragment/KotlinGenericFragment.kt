package com.taufik.kotlinhero.ui.home.kotlingeneric.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.FragmentKotlinGenericBinding

class KotlinGenericFragment : Fragment() {

    private lateinit var binding: FragmentKotlinGenericBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKotlinGenericBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionToHome()
    }

    private fun actionToHome() {
        binding.apply {
            toolbarMain.apply {
                toolbarTitle.text = getString(R.string.tvKotlinGeneric)
                toolbar.setNavigationOnClickListener {
                    requireActivity().onBackPressed()
                }
            }
        }
    }
}