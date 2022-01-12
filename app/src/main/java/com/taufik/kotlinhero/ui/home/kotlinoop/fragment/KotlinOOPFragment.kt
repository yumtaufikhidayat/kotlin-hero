package com.taufik.kotlinhero.ui.home.kotlinoop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.kotlinhero.databinding.FragmentKotlinOopBinding

class KotlinOOPFragment : Fragment() {

    private lateinit var binding: FragmentKotlinOopBinding
    private lateinit var title: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKotlinOopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBundle()
        actionToHome()
    }

    private fun initBundle() {
        title = arguments?.getString("title").toString()
    }

    private fun actionToHome() {
        binding.apply {
            toolbarMain.apply {
                toolbarTitle.text = title
                toolbar.setNavigationOnClickListener {
                    requireActivity().onBackPressed()
                }
            }
        }
    }
}