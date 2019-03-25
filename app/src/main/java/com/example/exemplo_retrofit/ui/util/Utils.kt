package com.example.exemplo_retrofit.ui.util

import android.content.Context
import android.widget.Toast

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class Utils {
    companion object {
        fun showShortToast(message: String, context: Context){
            showToast(message, Toast.LENGTH_SHORT, context)
        }

        fun showToast(message: String, duration: Int, context: Context){
            Toast.makeText(context,message,duration).show()
        }

        fun showLongToast(message: String, context: Context){
            showToast(message, Toast.LENGTH_LONG, context)
        }


    }

}