package id.ac.unhas.infocovid19.network


import id.ac.unhas.infocovid19.model.DataHarian
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPointHarian {
    @GET("harian")
    fun getDataHarian() : Call<DataHarian>
}