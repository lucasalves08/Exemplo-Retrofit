package com.example.exemplo_retrofit.ui.list

import android.content.Context
import com.example.exemplo_retrofit.network.bean.PollResponse
import com.example.exemplo_retrofit.network.service.AppAPI
import com.example.exemplo_retrofit.network.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class ListInteractorImpl : ListInteractor {

    lateinit var api: AppAPI
    override fun getAllPoll(listener: ListInteractor.OnListListener, context: Context) {
        val service = Service().getInstance()!!
        api = service.retrofit.create(AppAPI::class.java)


        val call :  Call<List<PollResponse>> = api.getAll()
        call.enqueue(object: Callback<List<PollResponse>?> {
            override fun onFailure(call: Call<List<PollResponse>?>?, t: Throwable) {
                listener.onError(t.localizedMessage)
            }
            override fun onResponse(call: Call<List<PollResponse>?>?, response: Response<List<PollResponse>?>) =
                if(response.isSuccessful){
                    listener.onGetAllSucess(response.body()!!)
                }
                else {
                    listener.onError(response.message())
                }
        })


    }

}