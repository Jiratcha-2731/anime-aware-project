package com.example.anime_aware

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anime_aware.adapter.AnimeListAdapter
import com.example.anime_aware.data.ApiClient
import com.example.anime_aware.data.ServiceBuilder
import com.example.anime_aware.model.Characters
import com.example.anime_aware.model.base
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainFragment :Fragment(){

    companion object{
        const val FRAGMENT_TAG = "MainFragment"
        fun create(): MainFragment {
            return MainFragment()
        }
    }

    private val animeListAdapter = AnimeListAdapter {
        didSelectAnime(it)
    }
    private var animeList: ArrayList<Characters>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = animeListAdapter
        }

        fetchData()
    }

    private fun fetchData() {
        val request = ServiceBuilder.buildService(ApiClient::class.java)
        val call = request.getAnimeCharacterList()

        call.enqueue(object : Callback<base> {
            override fun onResponse(
                call: retrofit2.Call<base>,
                response: Response<base>
            ) {
                if (response.isSuccessful) {
                    animeList = response.body()!!.characters
                    animeListAdapter.addItem(animeList)
                }
            }

            override fun onFailure(call: retrofit2.Call<base>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun didSelectAnime(characters: Characters?) {
        startActivity(DetailAnimeActivity.create(context!!, characters!!))
    }

}