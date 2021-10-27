package com.taufik.kotlinhero.ui.home.kotlincollection.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.taufik.kotlinhero.databinding.FragmentKotlinCollectionBinding

class KotlinCollectionFragment : Fragment() {

    private lateinit var binding: FragmentKotlinCollectionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKotlinCollectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionToHome()
    }

    private fun actionToHome() {
        binding.apply {
            cardBack.setOnClickListener {
                val intentAction = KotlinCollectionFragmentDirections.actionKotlinCollectionFragmentToNavHome()
                findNavController().navigate(intentAction)
            }
        }
    }
}