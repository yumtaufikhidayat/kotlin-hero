package com.taufik.kotlinhero.ui.home.kotlincoroutine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.taufik.kotlinhero.databinding.FragmentKotlinCoroutineBinding

class KotlinCoroutineFragment : Fragment() {

    private lateinit var binding: FragmentKotlinCoroutineBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKotlinCoroutineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionToHome()
    }

    private fun actionToHome() {
        binding.apply {
            cardBack.setOnClickListener {
                val intentAction = KotlinCoroutineFragmentDirections.actionKotlinCoroutineFragmentToNavHome()
                findNavController().navigate(intentAction)
            }
        }
    }
}