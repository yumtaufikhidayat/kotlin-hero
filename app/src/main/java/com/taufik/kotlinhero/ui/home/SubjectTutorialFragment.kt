package com.taufik.kotlinhero.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.kotlinhero.databinding.FragmentSubjectTutorialBinding

class SubjectTutorialFragment : Fragment() {

    private lateinit var binding: FragmentSubjectTutorialBinding
    private lateinit var title: String
    private lateinit var subtitle: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubjectTutorialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBundle()
        actionToHome()
    }

    private fun initBundle() {
        title = arguments?.getString("title").toString()
        subtitle = arguments?.getString("subtitle").toString()
    }

    private fun actionToHome() {
        binding.apply {
            toolbarMain.apply {
                toolbarTitle.text = title
                toolbarSubtitle.text = subtitle
                toolbar.setNavigationOnClickListener {
                    requireActivity().onBackPressed()
                }
            }
        }
    }
}