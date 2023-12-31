package com.example.movietop10.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //baseUrl은 오픈 api의 서버 url을 넣는다.
    var baseUrl: String = "https://www.kobis.or.kr"
    var api: RetrofitMovieApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            //json을 gson으로 파싱할거니까 GsonConverterFactory.create()로 gsonconverter를 가져온다.
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Retrofit 객체 생성

        api = retrofit.create(RetrofitMovieApi::class.java)
    }
}