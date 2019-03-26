package com.example.exemplo_retrofit.network.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */

class PollResponse(

    @SerializedName("poll_id")
    val id: Int,

    @SerializedName("poll_description")
    val description: String,

    val options: List<Option>
) : Serializable