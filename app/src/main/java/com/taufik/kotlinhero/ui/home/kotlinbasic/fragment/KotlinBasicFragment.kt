package com.taufik.kotlinhero.ui.home.kotlinbasic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.data.KotlinBasic
import com.taufik.kotlinhero.databinding.FragmentKotlinBasicBinding
import com.taufik.kotlinhero.model.learningmaterials.LearningMaterialsItem
import com.taufik.kotlinhero.ui.home.kotlinbasic.adapter.KotlinBasicAdapter
import java.util.*

class KotlinBasicFragment : Fragment() {

    private lateinit var binding: FragmentKotlinBasicBinding
    private lateinit var kotlinBasicAdapter: KotlinBasicAdapter
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

        actionToHome()

        setRecyclerViewKotlinBasic()
    }

    private fun actionToHome() {
        binding.apply {
            toolbarMain.apply {
                toolbarTitle.text = getString(R.string.tvKotlinBasic)
                toolbar.setNavigationOnClickListener {
                    requireActivity().onBackPressed()
                }
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