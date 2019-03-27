package com.example.exemplo_retrofit.ui.register

import android.app.ActionBar
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.exemplo_retrofit.R
import com.example.exemplo_retrofit.network.bean.NewPollRequest
import com.example.exemplo_retrofit.network.bean.NewPollResponse
import com.example.exemplo_retrofit.network.bean.Option
import com.example.exemplo_retrofit.ui.stats.StatsActivity
import com.example.exemplo_retrofit.ui.util.Utils
import kotlinx.android.synthetic.main.activity_register.*
import java.io.Serializable

class RegisterActivity : AppCompatActivity(), RegisterView {

    lateinit var presenter: RegisterPresenter
    var optionList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fabNewOption.setOnClickListener {
            createAlertEdit()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter = RegisterPresenterImpl(this, RegisterInteractorImpl(), this)
    }


    override fun showSucess(response: NewPollResponse) {
        Utils.showShortToast("Enquete cadastrada com Id: ${response.id}", this)

    }

    override fun getNewPollRequest(): NewPollRequest {
        val request = NewPollRequest(editDescription.text.toString(), optionList)
        return request

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.register_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
        R.id.itemMenu_register -> registerPoll()
        else -> super.onOptionsItemSelected(item)
    }


    fun registerPoll(): Boolean{
        if(editDescription.text.isEmpty()){
            editDescription.setError("Preencha esse campo")
            return false
        }
        if (optionList.count() < 2){
            Utils.showAlertWithMessage(this, "Insira pelo menos duas opções!")
            return false
        }
        presenter.postPoll()
        finish()
        return true
    }

    fun createAlertEdit() {
        val optionField: EditText = EditText(this)
        var linearPararms = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        optionField.layoutParams = linearPararms

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Opções")
            .setMessage("Entre com a opção")
            .setCancelable(true)
            .setView(optionField)
            .setPositiveButton("OK") { _: DialogInterface, _: Int  ->
                if(!optionField.text.isEmpty()) run {
                    optionList.add(optionField.text.toString())
                    textOptions.append("${optionList.count()}- ${optionField.text} \n")
                }
            }

            /*.setPositiveButton("Sim", positiveButtonClick)
            .setNegativeButton("Sair", negativeButtonClick)
            */
        alertDialog.show()
    }
}
