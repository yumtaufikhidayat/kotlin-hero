package com.taufik.kotlinhero.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.data.MainData
import com.taufik.kotlinhero.databinding.FragmentHomeBinding
import com.taufik.kotlinhero.model.aboutkotlin.AboutKotlinItem
import com.taufik.kotlinhero.model.category.CategoryItem
import com.taufik.kotlinhero.ui.reference.adapter.ReferenceKotlinAdapter

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var referenceKotlinAdapter: ReferenceKotlinAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private var aboutKotlinItemData = ArrayList<AboutKotlinItem>()
    private var categoryData = ArrayList<CategoryItem>()

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
        setRecyclerViewAboutKotlin()
        setRecyclerViewCategory()
    }

    private fun setRecyclerViewAboutKotlin() {

        aboutKotlinItemData = MainData.aboutKotlinData as ArrayList<AboutKotlinItem>
        referenceKotlinAdapter = ReferenceKotlinAdapter()

        binding.apply {
            referenceKotlinAdapter.setDataAboutKotlin(aboutKotlinItemData)
            with(rvAboutKotlin) {
                layoutManager = GridLayoutManager(requireActivity(), 3)
                setHasFixedSize(true)
                adapter = referenceKotlinAdapter
            }
        }
    }

    private fun setRecyclerViewCategory() = with(binding) {

        categoryData = MainData.categoryTutorialData as ArrayList<CategoryItem>
        categoryAdapter = CategoryAdapter { categoryItem, position ->
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

        categoryAdapter.setDataCategoryList(categoryData)
        with(rvCategory) {
            layoutManager = GridLayoutManager(requireActivity(), 2)
            setHasFixedSize(true)
            adapter = categoryAdapter
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