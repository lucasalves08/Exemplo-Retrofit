package com.example.exemplo_retrofit.ui.details

import android.content.Context
import com.example.exemplo_retrofit.network.service.AppAPI
import com.example.exemplo_retrofit.network.service.Service
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsInteractorImpl : DetailsInteractor {
    lateinit var api: AppAPI

    override fun sendVote(listener: DetailsInteractor.OnListListener, context: Context, optionId: Int, pollId: Int) {
        val service = Service()
        api = service.retrofit.create(AppAPI::class.java)

        val pararms = HashMap<String, Int>()
        pararms.put("option_id", optionId)

        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
            JSONObject(pararms).toString())

        val call: Call<Void> = api.sendVote(pollId, body)
        call.enqueue(object: Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                listener.onError(t.localizedMessage)
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful){
                    listener.onVoteSucess(response.message())
                }
                else {
                    listener.onError(response.message())
                }
            }
        })

    }
}