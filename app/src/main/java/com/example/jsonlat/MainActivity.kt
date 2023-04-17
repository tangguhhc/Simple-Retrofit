package com.example.jsonlat

import androidx.appcompat.app.AppCompatActivity
import com.example.jsonlat.databinding.ActivityMainBinding;

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initHome()
    }

    private fun initHome() {
        binding.rvPost.setHasFixedSize(true)
        binding.rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getUsers().enqueue(object: Callback<ArrayList<PostResponse>>{

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val responseCode = response.code().toString()
                binding.tvResponseCode.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                binding.rvPost.adapter = adapter

            }
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
            }

        })
    }
}