package com.example.exemplo_retrofit.network.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Lucas Alves dos Santos on 26/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class Vote (
    @SerializedName("option_id")
    val id: Int,

    @SerializedName("qty")
    val quantity: Int
): Serializable