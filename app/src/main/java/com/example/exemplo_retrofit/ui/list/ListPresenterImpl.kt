package com.example.exemplo_retrofit.ui.list

import android.content.Context
import com.example.exemplo_retrofit.network.bean.PollResponse
import com.example.exemplo_retrofit.ui.util.Utils

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class ListPresenterImpl(val view: ListView, val interactor: ListInteractor, private val context: Context) : ListPresenter, ListInteractor.OnListListener {


    override fun getAllPolls() {
        interactor.getAllPoll(this, context)

    }

    override fun onError(message: String) {
        Utils.showShortToast(message, context)
    }

    override fun onGetAllSucess(pollResponses: List<PollResponse>) {
        view.loadPolllist(pollResponses)
    }

}