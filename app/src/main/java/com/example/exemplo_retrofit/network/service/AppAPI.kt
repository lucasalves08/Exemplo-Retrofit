package com.example.exemplo_retrofit.network.service

import com.example.exemplo_retrofit.network.bean.PollResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

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

    @POST("/poll/{id}/vote")
    fun sendVote(@Path("id") id: Int, @Body body: RequestBody): Call<Void>

    /*GET("/poll/{id}")
    fun getById(@Path("id") id:Int): PollResponse*/


}