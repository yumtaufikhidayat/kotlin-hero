package com.taufik.kotlinhero.activity.learningmaterials.kotlinbasic

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.text.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.adapter.learningmaterials.LearningMaterialsAdapter
import com.taufik.kotlinhero.data.KotlinBasic
import com.taufik.kotlinhero.databinding.ActivityKotlinBasicBinding
import com.taufik.kotlinhero.model.learningmaterials.LearningMaterialsItem

class KotlinBasicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKotlinBasicBinding
    private lateinit var learningMaterialsAdapter: LearningMaterialsAdapter
    private var kotlinBasicData = ArrayList<LearningMaterialsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKotlinBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()

        setRecyclerViewKotlinBasic()
    }

    private fun initActionBar() {

        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.title = "Tutorial Kotlin Dasar"
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setRecyclerViewKotlinBasic() {

        kotlinBasicData = KotlinBasic.kotlinDasarData as ArrayList<LearningMaterialsItem>
        learningMaterialsAdapter = LearningMaterialsAdapter()

        binding.apply {
            rvKotlinBasic.layoutManager = LinearLayoutManager(this@KotlinBasicActivity)
            rvKotlinBasic.setHasFixedSize(true)
            learningMaterialsAdapter.setDataIntroduceKotlin(kotlinBasicData)
            rvKotlinBasic.adapter = learningMaterialsAdapter
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.nav_search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.nav_search)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.tvSearchVideo)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@KotlinBasicActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return true
    }
}