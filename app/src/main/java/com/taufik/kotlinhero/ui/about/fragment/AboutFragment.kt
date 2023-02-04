package com.taufik.kotlinhero.ui.about.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.FragmentAboutBinding
import com.taufik.kotlinhero.ui.about.adapter.AboutAdapter
import com.taufik.kotlinhero.ui.about.viewmodel.AboutViewModel

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AboutViewModel by viewModels()
    private lateinit var aboutAdapter: AboutAdapter

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

        setAboutAuthorData()
    }

    private fun setAboutAuthorData() {
        binding.apply {
            toolbarAbout.toolbarTitle.text = getString(R.string.icAbout)
            aboutAdapter = AboutAdapter { position ->
                when (position) {
                    0 -> {
                        val urlLink = "https://linkedin.com/in/taufik-hidayat"

                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlLink))
                            startActivity(Intent.createChooser(intent, "Open with:"))
                        } catch (e: Exception) {
                            Toast.makeText(
                                requireContext(),
                                "Silakan install browser terlebih dulu",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    1 -> {
                        val githubLink = "https://github.com/yumtaufikhidayat/kotlin-hero"
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubLink))
                            startActivity(Intent.createChooser(intent, "Open with:"))
                        } catch (e: Exception) {
                            Toast.makeText(
                                requireContext(),
                                "Silakan install browser terlebih dulu",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    2, 3 -> {
                        val email = "yumtaufikhidayat@gmail.com"
                        try {
                            val intentEmail = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null)).apply {
                                putExtra(Intent.EXTRA_EMAIL, email)
                                putExtra(Intent.EXTRA_SUBJECT, "")
                                putExtra(Intent.EXTRA_TEXT, "")
                            }
                            startActivity(Intent.createChooser(intentEmail, "Send email"))
                        } catch (e: java.lang.Exception) {
                            Toast.makeText(
                                requireContext(),
                                "Silakan install browser terlebih dulu",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

            aboutAdapter.setAboutAuthorData(viewModel.getAboutAuthor())
            with(rvAbout) {
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