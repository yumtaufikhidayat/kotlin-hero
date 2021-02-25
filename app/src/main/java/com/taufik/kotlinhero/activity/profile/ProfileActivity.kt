package com.taufik.kotlinhero.activity.profile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.taufik.kotlinhero.R
import com.taufik.kotlinhero.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
    }

    private fun initActionBar() {

        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.title = "Profil"
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.profile_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()

            R.id.nav_detail_profile -> {

//                val profileInfo = BottomSheetProfileInfo()
//
//                profileInfo.setStyle(
//                    DialogFragment.STYLE_NORMAL,
//                    R.style.BaseBottomSheetMenu
//                )
//
//                profileInfo.show(supportFragmentManager, "profileInfoBottomSheet")
            }

            R.id.nav_share_profile -> {

//                try {
//                    val body = "Visit this awesome user \n${data.html_url}"
//                    val shareIntent = Intent(Intent.ACTION_SEND)
//                    shareIntent.type = "text/plain"
//                    shareIntent.putExtra(Intent.EXTRA_TEXT, body)
//                    startActivity(Intent.createChooser(shareIntent, "Share with:"))
//                } catch (e: Exception) {
//                    Log.e("shareFailed", "onOptionsItemSelected: ${e.localizedMessage}")
//                }
            }

            R.id.nav_open_in_browser_profile -> {

//                try {
//                    val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(data.html_url))
//                    startActivity(Intent.createChooser(intentBrowser, "Open with:"))
//                } catch (e: java.lang.Exception) {
//                    Log.e("errorIntent", "onBindViewHolder: ${e.localizedMessage}")
//                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}