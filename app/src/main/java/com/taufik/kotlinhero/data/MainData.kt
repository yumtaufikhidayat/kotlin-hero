package com.taufik.kotlinhero.data

import com.taufik.kotlinhero.helper.UrlHelper
import com.taufik.kotlinhero.model.learningmaterials.LearningMaterialsItem

class MainData {
    companion object{
        val kotlinData: List<LearningMaterialsItem>
            get() = mutableListOf(
                LearningMaterialsItem(
                    "1. Pengenalan Kotlin",
                    "Pada video kali ini akan dibahas tentang ",
                    UrlHelper.VIDEO_KOTLIN_DASAR_1
                ),

                LearningMaterialsItem(
                    "2. Program Hello World",
                    "Pada video kali ini akan dibahas tentang ",
                    UrlHelper.VIDEO_KOTLIN_DASAR_1
                ),

                LearningMaterialsItem(
                    "3. Tipe Data Number",
                    "Pada video kali ini akan dibahas tentang ",
                    UrlHelper.VIDEO_KOTLIN_DASAR_1
                ),

                LearningMaterialsItem(
                    "4. Tipe Data Character",
                    "Pada video kali ini akan dibahas tentang ",
                    UrlHelper.VIDEO_KOTLIN_DASAR_1
                )
            )
    }
}