package com.example.exemplo_retrofit.ui.register

import android.content.Context
import com.example.exemplo_retrofit.network.bean.NewPollResponse
import com.example.exemplo_retrofit.ui.util.Utils


class RegisterPresenterImpl(val view: RegisterView, val interactor: RegisterInteractor, val context: Context) : RegisterPresenter, RegisterInteractor.onPostListener {

    override fun onError(message: String) {
        Utils.showShortToast("Error: $message", context)

    }

    override fun onPostPollSucess(response: NewPollResponse) {
        view.showSucess(response)

    }

    override fun postPoll() {
        val request = view.getNewPollRequest()
        interactor.postPoll(this, context, request)
    }
}