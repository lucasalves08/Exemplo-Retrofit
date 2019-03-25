package com.example.exemplo_retrofit.ui.list


import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exemplo_retrofit.R
import com.example.exemplo_retrofit.network.bean.PollResponse
import kotlinx.android.synthetic.main.poll_item.view.*

/**
 * Created by Lucas Alves dos Santos on 25/03/2019.
 * lsantos@luxfacta.com
 * For Luxfacta Soluções de TI
 * {@see more in https://www.luxfacta.com}
 */
class ListAdapter(private val polls: List<PollResponse>,
                    private val context: Context) : Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.poll_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return polls.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poll = polls[position]
        holder.let {
            it.bindView(poll)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(poll: PollResponse){
            val description = itemView.textDescription
            description.text = poll.description
        }
    }

}