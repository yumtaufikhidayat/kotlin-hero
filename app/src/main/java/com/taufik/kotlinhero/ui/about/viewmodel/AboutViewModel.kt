package com.taufik.kotlinhero.ui.about.viewmodel

import androidx.lifecycle.ViewModel
import com.taufik.kotlinhero.data.MainData
import com.taufik.kotlinhero.data.local.About

class AboutViewModel : ViewModel() {
    fun getAboutAuthor(): List<About> = MainData.generateAboutAuthorData()
}