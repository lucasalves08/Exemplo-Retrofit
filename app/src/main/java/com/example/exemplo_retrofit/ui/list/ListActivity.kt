package com.example.exemplo_retrofit.ui.list

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import com.example.exemplo_retrofit.R
import com.example.exemplo_retrofit.network.bean.PollResponse
import com.example.exemplo_retrofit.ui.details.DetailsActivity
import com.example.exemplo_retrofit.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_list.*
import java.io.Serializable

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
        progressBar.visibility = View.VISIBLE
        recyclerView.adapter = ListAdapter(pollResponseList, this)
        progressBar.visibility = View.GONE

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.list_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
        R.id.itemMenu_new -> goToRegister()
        else -> super.onOptionsItemSelected(item)
    }

    fun goToRegister():Boolean {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        return true











    }

}
