package com.example.movietop10

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.movietop10.DataVo.BoxOfficeResult
import com.example.movietop10.DataVo.MovieData
import com.example.movietop10.Retrofit.RetrofitClient
import com.example.movietop10.databinding.ActivityMovierankBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.job
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.GregorianCalendar

class MovieRankActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovierankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovierankBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar = GregorianCalendar()
        val SDF = SimpleDateFormat("yyyyMMdd")
        calendar.add(Calendar.DATE,-1)
        val res = SDF.format(calendar.time)

        runBlocking {
            val task = GlobalScope.async {
                RetrofitClient.api
                    .getMovieList(res, BuildConfig.MOVIE_API_KEY)
                    .enqueue(object : Callback<BoxOfficeResult> {
                        override fun onFailure(call: Call<BoxOfficeResult>, t: Throwable) {
                            //통신 실패한 경우
                            Log.d("fail","${t.message}")
                        }

                        override fun onResponse(
                            call: Call<BoxOfficeResult>,
                            response: Response<BoxOfficeResult>
                        ) {
                            val movieResponse = response.body()
                            val list: List<MovieData> = movieResponse!!.boxofficeResult!!.dailyBoxOfficeList
                            Log.d("MY", "$list")
                        }
                    })
            }
            task.join()
        }


    }
}