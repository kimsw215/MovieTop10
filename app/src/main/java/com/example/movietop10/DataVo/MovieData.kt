package com.example.movietop10.DataVo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieData(
    //@SerialzedName : JSON에서 데이터에 매칭되는 이름 명시
    //@Expose : 해당값이 null일경우 json으로 만들 필드를 자동 생략하겠다! 는 명령어
    @SerializedName("movieNm")
    var movieNm: String?,
    @SerializedName("rankInten")
    var rankInten: String?,
    @SerializedName("rank")
    var rank: String?,
    @SerializedName("movieCd")
    var movieCd: Int?,
    @SerializedName("openDt")
    var openDt: Int?,
    @SerializedName("audiAcc")
    var audiAcc: Int?
) : Parcelable

