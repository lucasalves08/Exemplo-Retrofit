package com.example.exemplo_retrofit.ui.details

import android.content.Context
import com.example.exemplo_retrofit.network.bean.PollResponse

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
interface DetailsInteractor {

    interface OnListListener {
        fun onError(message : String)
        fun onVoteSucess(message: String)
    }
    fun sendVote(listener:OnListListener, context: Context, optionId: Int, pollId: Int)
}