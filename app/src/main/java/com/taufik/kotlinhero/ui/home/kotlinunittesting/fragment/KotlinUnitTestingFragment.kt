package com.taufik.kotlinhero.ui.home.kotlinunittesting.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.kotlinhero.databinding.FragmentKotlinUnitTestingBinding
import com.taufik.kotlinhero.ui.home.HomeFragment

class KotlinUnitTestingFragment : Fragment() {

    private lateinit var binding: FragmentKotlinUnitTestingBinding
    private lateinit var title: String
    private lateinit var subTitle: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKotlinUnitTestingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBundle()
        actionToHome()
    }

    private fun initBundle() {
        arguments?.apply {
            title = getString(HomeFragment.EXTRA_TITLE).toString()
            subTitle = getString(HomeFragment.EXTRA_SUBTITLE).toString()
        }
    }

    private fun actionToHome() {
        binding.apply {
            toolbarMain.apply {
                toolbarTitle.text = title
                toolbarSubtitle.text = subTitle
                toolbar.setNavigationOnClickListener {
                    requireActivity().onBackPressed()
                }
            }
        }
    }
}