package com.taufik.kotlinhero.model.learningmaterials

data class LearningMaterialsItem(
        val titleNumber: String,
        val titleName: String,
        val description: String,
        val embedVideoUrl: String,
        val videoUrl: String,
        var isExpandable: Boolean = false
)
