package com.example.exemplo_retrofit.network.service

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class Service {
    val BASE_API_URL = "http://enqueteapi.luxfacta.com/"

    var retrofit : Retrofit
    var mInstance: Service? = null
    init{
        if(mInstance != null){
            throw RuntimeException("Use getInstance() method to get the single instance of this class.")
        }
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getInstance(): Service? {
        if(mInstance==null) {
            mInstance = Service()
        }
        return mInstance

    }

}