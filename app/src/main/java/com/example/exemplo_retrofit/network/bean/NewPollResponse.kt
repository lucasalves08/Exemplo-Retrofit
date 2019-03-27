package com.example.exemplo_retrofit.network.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by Lucas Alves dos Santos on 27/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class NewPollResponse (
    @SerializedName("poll_id")
    val id: Int
)