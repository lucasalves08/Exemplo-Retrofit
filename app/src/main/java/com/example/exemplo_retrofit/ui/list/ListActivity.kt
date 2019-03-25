package com.example.exemplo_retrofit.ui.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.exemplo_retrofit.R
import com.example.exemplo_retrofit.network.bean.PollResponse
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), ListView {

    lateinit var presenter:ListPresenter
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = pollList
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()
        presenter = ListPresenterImpl(this, ListInteractorImpl(), this)
        presenter.getAllPolls()

    }

    override fun loadPolllist(pollResponseList: List<PollResponse>) {
        recyclerView.adapter = ListAdapter(pollResponseList, this)


    }

}
