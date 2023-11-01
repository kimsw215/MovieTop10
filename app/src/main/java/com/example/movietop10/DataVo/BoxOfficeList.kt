package com.example.movietop10.DataVo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BoxOfficeList (
    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList: List<MovieData> = arrayListOf()
) : Parcelable