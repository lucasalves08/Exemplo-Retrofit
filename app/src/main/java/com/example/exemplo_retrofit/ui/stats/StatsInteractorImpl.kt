package com.example.exemplo_retrofit.ui.stats

import android.content.Context
import com.example.exemplo_retrofit.network.bean.StatsResponse
import com.example.exemplo_retrofit.network.service.AppAPI
import com.example.exemplo_retrofit.network.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatsInteractorImpl : StatsInteractor {
    lateinit var api: AppAPI
    override fun getStats(listener: StatsInteractor.OnStatsListener, context: Context, pollId: Int) {
        val service = Service().getInstance()!!
        api = service.retrofit.create(AppAPI::class.java)

        val call : Call<StatsResponse> = api.getStatsById(pollId)

        call.enqueue(object : Callback<StatsResponse> {
            override fun onFailure(call: Call<StatsResponse>, t: Throwable) {
                listener.onError(t.localizedMessage)
            }

            override fun onResponse(call: Call<StatsResponse>, response: Response<StatsResponse>) {
                if(response.isSuccessful) {
                    listener.onGetStatsSucess(response.body()!!)
                }
                else {
                    listener.onError(response.message())
                }
            }

        })

    }
}