package com.taufik.kotlinhero.model.learningmaterials

data class LearningMaterialsItem(
        val title: String,
        val description: String,
        val videoUrl: String,
        var isExpandable: Boolean = false
)
