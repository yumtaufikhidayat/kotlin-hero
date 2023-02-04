package com.taufik.kotlinhero.ui.home.kotlinoop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.kotlinhero.databinding.FragmentKotlinOopBinding
import com.taufik.kotlinhero.ui.home.HomeFragment

class KotlinOOPFragment : Fragment() {

    private var _binding: FragmentKotlinOopBinding? = null
    private val binding get() = _binding!!
    private var title: String = ""
    private var subTitle: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKotlinOopBinding.inflate(inflater, container, false)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}