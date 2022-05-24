package com.melvin.ongandroid.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.businesslogic.repository.NewsRepository
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.model.APIServiceNews
import com.melvin.ongandroid.model.Novedades
import com.melvin.ongandroid.model.ONGApi
import com.melvin.ongandroid.model.data.NewResponse
import com.melvin.ongandroid.model.data.News
import com.melvin.ongandroid.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsFragment : Fragment(R.layout.fragment_news) {

    // private lateinit var recyclerView: RecyclerView
    private lateinit var newsList: ArrayList<Novedades>
    private lateinit var newsAdapter: NewsAdapter

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        newsList = ArrayList()

        addDataToList()

        newsAdapter = NewsAdapter(newsList)
        binding.recyclerView.adapter = newsAdapter
    }


    private fun addDataToList() {
        getMovieData { news: List<News> ->
            for (new in news){
                newsList.add(
                    Novedades(
                        R.drawable.voluntario_pobreza,
                        newName = new.name.toString(),
                        "Help, help, help, help help help help help"
                    )
                )
            }
        }
        newsList.add(
            Novedades(
                R.drawable.voluntario_pobreza,
                newName = "something 1",
                "Help, help, help, help help help help help"
            )
        )
    }

    private fun getMovieData(callback: (List<News>) -> Unit){
        val srv = ONGApi.newsService
        srv.getNews().enqueue(object : Callback<NewResponse> {

            override fun onFailure(call: Call<NewResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<NewResponse>, response: Response<NewResponse>) {
                return callback(response.body()!!.data)
            }

        })
    }

}