package com.example.exemplo_retrofit.network.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Lucas Alves dos Santos on 27/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class NewPollRequest (
    @SerializedName("poll_description")
    val name: String,

    val options: List<String>

):Serializable