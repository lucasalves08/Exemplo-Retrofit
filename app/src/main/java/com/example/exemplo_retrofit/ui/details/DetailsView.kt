package com.example.exemplo_retrofit.ui.details

import com.example.exemplo_retrofit.network.bean.PollResponse

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
interface DetailsView {
    fun fillDescription(pollResponse: PollResponse)
    fun createRadioButton(pollResponse: PollResponse)
    fun showSucess()
}