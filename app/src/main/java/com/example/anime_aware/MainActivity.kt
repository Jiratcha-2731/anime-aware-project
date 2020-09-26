package com.example.anime_aware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            title = "Anime"
        }

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.containerView, MainFragment.create(), MainFragment.FRAGMENT_TAG)
                .commit()
        }
    }

}

