package com.example.exemplo_retrofit.ui.details

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.exemplo_retrofit.R
import com.example.exemplo_retrofit.network.bean.PollResponse
import com.example.exemplo_retrofit.ui.stats.StatsActivity
import com.example.exemplo_retrofit.ui.util.Utils
import kotlinx.android.synthetic.main.activity_details.*
import java.io.Serializable

class DetailsActivity : AppCompatActivity(), DetailsView {

    var id: Int = -1
    lateinit var presenter: DetailsPresenter
    lateinit var poll: PollResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        poll = intent.getSerializableExtra("poll") as PollResponse
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            id = checkedId
        }

        btnVote.setOnClickListener {
            if(id != -1){
                presenter.vote(id, poll.id)
                Utils.showShortToast("id: $id", this)
                val alertDialog = AlertDialog.Builder(this)
                    .setTitle("Estatísticas")
                    .setMessage("Deseja ver a estatíscas dessa enquete?")
                    .setPositiveButton("Sim", positiveButtonClick)
                    .setNegativeButton("Sair", negativeButtonClick)
                    .setCancelable(true)
                alertDialog.show()
            }
            else {
                Utils.showShortToast("Escolha uma opção", this)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        presenter = DetailsPresenterImpl(this, DetailsInteractorImpl(), this)
        presenter.getPollDetails(poll)
    }

    override fun fillDescription(pollResponse: PollResponse) {
        textDesc.text = pollResponse.description

    }

    override fun createRadioButton(pollResponse: PollResponse) {
        for(option in pollResponse.options){
            val radioButton = RadioButton(this)
            radioButton.id = option.id
            radioButton.text = option.name
            radioGroup.addView(radioButton)
        }



    }

    override fun showSucess() {
        Utils.showLongToast("Votado com Sucesso!", this)

    }

    private val positiveButtonClick = { dialog: DialogInterface, witch: Int  ->
        val intent = Intent(this, StatsActivity::class.java)
        intent.putExtra("poll", poll as Serializable)
        startActivity(intent)
        finish()
    }

    private val negativeButtonClick = { dialog: DialogInterface, witch: Int  ->
        finish()
    }


}


