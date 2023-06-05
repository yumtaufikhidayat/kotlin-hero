package com.taufik.kotlinhero.ui.home.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.taufik.kotlinhero.data.NetworkResult
import com.taufik.kotlinhero.databinding.FragmentHomeBinding
import com.taufik.kotlinhero.model.response.ListCoursesItem
import com.taufik.kotlinhero.ui.home.adapter.CourseCategoryAdapter
import com.taufik.kotlinhero.ui.home.viewmodel.HomeViewModel
import com.taufik.kotlinhero.ui.home.adapter.ReferenceKotlinAdapter
import com.taufik.kotlinhero.utils.ToastUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        showAboutCategory()
        setCategoryObserver()
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

    private fun setCategoryObserver() {
        homeViewModel.getAllListCourses().observe(viewLifecycleOwner) {
            when(it) {
                is NetworkResult.Loading -> {
                    showLoading(true)
                    showError(false, "")
                }
                is NetworkResult.Success -> {
                    showLoading(false)
                    showError(false, "")
                    showCourseCategory(it.data)
                }
                is NetworkResult.Error -> {
                    showLoading(false)
                    showError(true, it.error)
                }
                is NetworkResult.ServerError -> {
                    showLoading(false)
                    showError(true, it.error)}
                is NetworkResult.Unauthorized -> {
                    showLoading(false)
                    showError(true, it.error)}
            }
        }
    }

    private fun showCourseCategory(data: ArrayList<ListCoursesItem>) {
        courseCategoryAdapter = CourseCategoryAdapter { categoryItem, position ->
            Toast.makeText(requireContext(), "${categoryItem.name}\n${data[position].name}", Toast.LENGTH_SHORT).show()
        }

        binding.rvCategory.apply {
            layoutManager = GridLayoutManager(requireActivity(), 2)
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
            adapter = courseCategoryAdapter
        }

        courseCategoryAdapter?.submitList(data)
    }

    private fun showLoading(isShow: Boolean) {
        binding.shimmerCategory.isVisible = isShow
    }

    private fun showError(isShow: Boolean, message: String) {
        binding.apply {
            tvError.isVisible = isShow
            btnRetry.isVisible = isShow

            tvError.text = message
            btnRetry.setOnClickListener {
                setCategoryObserver()
            }
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