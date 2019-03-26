package com.example.exemplo_retrofit.ui.stats

import android.content.Context
import com.example.exemplo_retrofit.network.bean.StatsResponse

/**
 * Created by Lucas Alves dos Santos on 26/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
interface StatsInteractor {
    interface OnStatsListener{
        fun onError(message: String)
        fun onGetStatsSucess(statsResponse: StatsResponse)
    }
    fun getStats(listener: OnStatsListener, context: Context, pollId: Int)
}