package com.example.anime_aware

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.anime_aware.data.ApiClient
import com.example.anime_aware.data.ServiceBuilder
import com.example.anime_aware.model.Characters
import com.example.anime_aware.model.DetailsCharacter
import kotlinx.android.synthetic.main.activity_detail_anime.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import retrofit2.Callback
import retrofit2.Response

class DetailAnimeActivity : AppCompatActivity() {

    companion object{
        private const val BUNDLE_ANIME = "BUNDLE_ANIME"
        fun create(context: Context, characters: Characters): Intent {

            return Intent(context, DetailAnimeActivity::class.java).apply {
                putExtra(BUNDLE_ANIME, characters)
            }
        }
    }

    private val characters: Characters? get() = intent?.getParcelableExtra(BUNDLE_ANIME)
    private  var detailCharacters : DetailsCharacter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anime)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Anime Detail"
        }

        fetchData()

    }

    private fun fetchData() {
        val request = ServiceBuilder.buildService(ApiClient::class.java)
        val call = request.getAnimeDetail(characters!!.malId)

        call.enqueue(object : Callback<DetailsCharacter> {
            override fun onResponse(
                call: retrofit2.Call<DetailsCharacter>,
                response: Response<DetailsCharacter>
            ) {
                if (response.isSuccessful) {
                    detailCharacters = response.body()
                    println(response.body()!!.about)
                    updateUI()
                }
            }

            override fun onFailure(call: retrofit2.Call<DetailsCharacter>, t: Throwable) {
                Toast.makeText(this@DetailAnimeActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun updateUI() {
        characters!!.imageUrl.apply {
            Glide.with(this@DetailAnimeActivity).load(this).into(image_anime)
        }
        role.text = characters!!.role
        about.text = detailCharacters?.about
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount < 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}