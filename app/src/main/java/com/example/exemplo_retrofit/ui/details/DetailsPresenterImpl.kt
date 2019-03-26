package com.example.exemplo_retrofit.ui.details

import android.content.Context
import com.example.exemplo_retrofit.network.bean.PollResponse
import com.example.exemplo_retrofit.ui.util.Utils

class DetailsPresenterImpl(val view: DetailsView, val interactor: DetailsInteractor, val context: Context) : DetailsPresenter, DetailsInteractor.OnListListener {


    override fun vote(optionId: Int, pollId: Int) {
        interactor.sendVote(this,context,optionId,pollId)
    }

    override fun getPollDetails(pollResponse: PollResponse) {
        view.fillDescription(pollResponse)
        view.createRadioButton(pollResponse)
    }

    override fun onError(message: String) {
        Utils.showShortToast("Error $message", context)

    }
    override fun onVoteSucess(message: String) {
        view.showSucess()
    }
}