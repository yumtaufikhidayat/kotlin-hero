package com.taufik.kotlinhero.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.FragmentHomeBinding
import com.taufik.kotlinhero.ui.home.viewmodel.HomeViewModel
import com.taufik.kotlinhero.ui.reference.adapter.ReferenceKotlinAdapter
import com.taufik.kotlinhero.utils.ToastUtils

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()
    private var referenceKotlinAdapter: ReferenceKotlinAdapter? = null
    private var courseCategoryAdapter: CourseCategoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerViewLayout()
    }

    private fun setRecyclerViewLayout() {
        showAboutCategory()
        showCourseCategory()
    }

    private fun showAboutCategory() {
        referenceKotlinAdapter = ReferenceKotlinAdapter { position ->
            when (position) {
                0 -> openBrowser("https://kotlinlang.org/docs/home.html")
                1 -> openBrowser("https://kotlinlang.org/docs/coding-conventions.html")
                2 -> openBrowser("https://kotlinlang.org/docs/contribute.html")
            }
        }
        referenceKotlinAdapter?.submitList(homeViewModel.showReferenceData())

        binding.rvAboutKotlin.apply {
            layoutManager = GridLayoutManager(requireActivity(), 3)
            setHasFixedSize(true)
            adapter = referenceKotlinAdapter
        }
    }

    private fun showCourseCategory() {
        courseCategoryAdapter = CourseCategoryAdapter { categoryItem, position ->
            val bundle = bundleOf(
                EXTRA_TITLE to categoryItem.categoryName,
                EXTRA_SUBTITLE to categoryItem.categoryNumber
            )

            when (position) {
                0 -> findNavController().navigate(R.id.kotlinBasicFragment, bundle)
                1 -> findNavController().navigate(R.id.kotlinOOPFragment, bundle)
                2 -> findNavController().navigate(R.id.kotlinGenericFragment, bundle)
                3 -> findNavController().navigate(R.id.kotlinCollectionFragment, bundle)
                4 -> findNavController().navigate(R.id.kotlinCoroutineFragment, bundle)
                5 -> findNavController().navigate(R.id.kotlinUnitTestingFragment, bundle)
            }
        }
        courseCategoryAdapter?.submitList(homeViewModel.showCourseCategory())

        binding.rvCategory.apply {
            layoutManager = GridLayoutManager(requireActivity(), 2)
            setHasFixedSize(true)
            adapter = courseCategoryAdapter
        }
    }

    private fun openBrowser(url: String) {
        try {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )
            startActivity(Intent.createChooser(intent, "Buka dengan"))
        } catch (e: Exception) {
            ToastUtils.showToast(requireContext(), "Silakan install browser terlebih dulu")
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_TITLE = "com.taufik.kotlinhero.ui.home.EXTRA_TITLE"
        const val EXTRA_SUBTITLE = "com.taufik.kotlinhero.ui.home.EXTRA_SUBTITLE"
    }
}