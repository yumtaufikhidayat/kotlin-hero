package com.taufik.kotlinhero.ui.about.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.kotlinhero.data.MainData
import com.taufik.kotlinhero.databinding.FragmentAboutBinding
import com.taufik.kotlinhero.ui.about.adapter.AboutAdapter

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private lateinit var aboutAdapter: AboutAdapter
    private var dataList = listOf<Any>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAboutData()
    }

    private fun setAboutData() {
        dataList = MainData.aboutCategory
        aboutAdapter = AboutAdapter(dataList)

        binding.apply {
            with(rvAboutParentCategory) {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = aboutAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}