package com.example.exemplo_retrofit.ui.register

import com.example.exemplo_retrofit.network.bean.NewPollRequest
import com.example.exemplo_retrofit.network.bean.NewPollResponse

/**
 * Created by Lucas Alves dos Santos on 27/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
interface RegisterView {
    fun showSucess(response: NewPollResponse)
    fun getNewPollRequest(): NewPollRequest
}