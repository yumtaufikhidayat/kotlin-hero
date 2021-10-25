package com.taufik.kotlinhero.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.taufik.kotlinhero.data.MainData
import com.taufik.kotlinhero.databinding.FragmentHomeBinding
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem
import com.taufik.kotlinhero.model.category.CategoryItem
import com.taufik.kotlinhero.ui.adapter.about.AboutKotlinAdapter
import com.taufik.kotlinhero.ui.adapter.category.CategoryAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var aboutKotlinAdapter: AboutKotlinAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private var aboutKotlinItemData = ArrayList<AboutKotlinItem>()
    private var categoryData = ArrayList<CategoryItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerViewLayout()
    }

    private fun setRecyclerViewLayout() {

        setRecyclerViewAboutKotlin()

        setRecyclerViewCategory()
    }

    private fun setRecyclerViewAboutKotlin() {

        aboutKotlinItemData = MainData.aboutKotlinData as ArrayList<AboutKotlinItem>
        aboutKotlinAdapter = AboutKotlinAdapter()

        binding.apply {
            rvAboutKotlin.layoutManager = GridLayoutManager(requireActivity(), 3)
            rvAboutKotlin.setHasFixedSize(true)
            aboutKotlinAdapter.setDataAboutKotlin(aboutKotlinItemData)
            rvAboutKotlin.adapter = aboutKotlinAdapter
        }
    }

    private fun setRecyclerViewCategory() {

        categoryData = MainData.categoryTutorialData as ArrayList<CategoryItem>
        categoryAdapter = CategoryAdapter()

        binding.apply {
            rvCategory.layoutManager = GridLayoutManager(requireActivity(), 2)
            rvCategory.setHasFixedSize(true)
            categoryAdapter.setDataCategoryList(categoryData)
            rvCategory.adapter = categoryAdapter
        }
    }
}