package com.example.exemplo_retrofit.ui.stats

import android.content.Context
import com.example.exemplo_retrofit.network.bean.StatsResponse
import com.example.exemplo_retrofit.ui.util.Utils

class StatsPresenterImpl (val view: StatsView, val interactor: StatsInteractor, val context: Context): StatsPresenter, StatsInteractor.OnStatsListener {

    override fun onError(message: String) {
        Utils.showShortToast("Error: $message", context)
    }

    override fun onGetStatsSucess(statsResponse: StatsResponse) {
        view.loadStats(statsResponse)

    }

    override fun getStats(pollId: Int) {
        interactor.getStats(this,context,pollId)
    }
}