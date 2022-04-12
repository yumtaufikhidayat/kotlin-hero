package com.taufik.kotlinhero.ui.home.kotlinbasic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.kotlinhero.data.KotlinBasic
import com.taufik.kotlinhero.databinding.FragmentKotlinBasicBinding
import com.taufik.kotlinhero.model.learningmaterials.LearningMaterialsItem
import com.taufik.kotlinhero.ui.home.HomeFragment.Companion.EXTRA_SUBTITLE
import com.taufik.kotlinhero.ui.home.HomeFragment.Companion.EXTRA_TITLE
import com.taufik.kotlinhero.ui.home.kotlinbasic.adapter.KotlinBasicAdapter

class KotlinBasicFragment : Fragment() {

    private lateinit var binding: FragmentKotlinBasicBinding
    private lateinit var kotlinBasicAdapter: KotlinBasicAdapter
    private lateinit var title: String
    private lateinit var subTitle: String
    private var kotlinBasicData = ArrayList<LearningMaterialsItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKotlinBasicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBundle()
        actionToHome()
        setRecyclerViewKotlinBasic()
    }

    private fun initBundle() {
        arguments?.apply {
            title = getString(EXTRA_TITLE).toString()
            subTitle = getString(EXTRA_SUBTITLE).toString()
        }
    }

    private fun actionToHome() = with(binding){
        toolbarMain.apply {
            toolbarTitle.text = title
            toolbarSubtitle.text = subTitle
            toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun setRecyclerViewKotlinBasic() {

        kotlinBasicData = KotlinBasic.kotlinDasarData as ArrayList<LearningMaterialsItem>
        kotlinBasicAdapter = KotlinBasicAdapter()

        binding.apply {
            kotlinBasicAdapter.setDataIntroduceKotlin(kotlinBasicData)
            with(rvKotlinBasic) {
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = kotlinBasicAdapter
            }
        }
    }
}