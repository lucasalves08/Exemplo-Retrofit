package com.example.exemplo_retrofit.ui.register

import android.content.Context
import com.example.exemplo_retrofit.network.bean.NewPollRequest
import com.example.exemplo_retrofit.network.bean.NewPollResponse
import com.example.exemplo_retrofit.network.service.AppAPI
import com.example.exemplo_retrofit.network.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterInteractorImpl : RegisterInteractor {

    lateinit var api: AppAPI
    override fun postPoll(listener: RegisterInteractor.onPostListener, context: Context, request: NewPollRequest) {
        val service = Service()
        api = service.retrofit.create(AppAPI::class.java)

        val call: Call<NewPollResponse> = api.createNewPoll(request)

        call.enqueue(object : Callback<NewPollResponse> {
            override fun onFailure(call: Call<NewPollResponse>, t: Throwable) {
                listener.onError(t.localizedMessage)
            }
            override fun onResponse(call: Call<NewPollResponse>, response: Response<NewPollResponse>) {
                if(response.isSuccessful)
                    listener.onPostPollSucess(response.body()!!)
                else
                    listener.onError(response.message())
            }
        })
    }
}