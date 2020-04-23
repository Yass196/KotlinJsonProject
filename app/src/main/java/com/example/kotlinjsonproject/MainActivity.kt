package com.example.kotlinjsonproject

import android.app.AlertDialog
import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinjsonproject.Adapter.MovieAdapter
import com.example.kotlinjsonproject.Common.Common
import com.example.kotlinjsonproject.Interface.RetrofitService
import com.example.kotlinjsonproject.Model.Movie
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var service : RetrofitService
    lateinit var adapter: MovieAdapter
    lateinit var dialog : AlertDialog
    lateinit var layoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        service = Common.RETROSERVICE
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
getAllMovieList()
    }

    private fun getAllMovieList(){
        dialog.show()
        service.getMovieList().enqueue(object : Callback<MutableList<Movie>>{
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                adapter = MovieAdapter(baseContext, response.body() as MutableList<Movie> )
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter
                dialog.dismiss()
            }

        })
        }
    }


