package com.taufik.kotlinhero.ui.favorite.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFavoriteData()
    }

    private fun setFavoriteData() {
        binding.apply {
            toolbarFavorite.toolbarTitle.text = getString(R.string.icFavorite)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}