package com.example.exemplo_retrofit.network.service

import com.example.exemplo_retrofit.network.bean.PollResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
interface AppAPI {
    @Headers (
        "Content-type: application/json"
    )

    @GET("/poll")
    fun getAll(): Call<List<PollResponse>>

    @GET("/poll/{id}")
    fun getById(@Path("id") id:Int): PollResponse


}