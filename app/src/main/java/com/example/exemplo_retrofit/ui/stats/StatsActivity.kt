package com.example.exemplo_retrofit.ui.stats

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.example.exemplo_retrofit.R
import com.example.exemplo_retrofit.network.bean.PollResponse
import com.example.exemplo_retrofit.network.bean.StatsResponse
import com.example.exemplo_retrofit.ui.util.Utils
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.activity_stats.*

class StatsActivity : AppCompatActivity(), StatsView{

    lateinit var poll: PollResponse
    lateinit var presenter: StatsPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        poll = intent.getSerializableExtra("poll") as PollResponse



    }

    override fun onResume() {
        super.onResume()
        presenter = StatsPresenterImpl(this, StatsInteractorImpl(), this)
        presenter.getStats(poll.id)
    }

    override fun loadStats(statsResponse: StatsResponse) {
        textView.text = statsResponse.views.toString()
        val graph = ArrayList<BarEntry>()
        graph.add(BarEntry(0f, 0f))
        var i: Int = 0
        for(option in poll.options){
            graph.add(BarEntry(i.toFloat(), statsResponse.votes[i].quantity.toFloat(), option.name))
            i++
        }

        // creating dataset for Bar Group
        val barDataSet = BarDataSet(graph, "Votos em cada opção")

        barDataSet.color = ContextCompat.getColor(this, R.color.likewise)

        progressBar2.visibility = View.VISIBLE
        val data = BarData(barDataSet)
        progressBar2.visibility = View.GONE
        barChart.setData(data)
        barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        barChart.xAxis.labelCount = poll.options.size
        barChart.xAxis.enableGridDashedLine(5f, 5f, 0f)
        barChart.axisRight.enableGridDashedLine(5f, 5f, 0f)
        barChart.axisLeft.enableGridDashedLine(5f, 5f, 0f)
        barChart.description.isEnabled = true
        barChart.animateY(1000)
        barChart.legend.isEnabled = true
        barChart.setPinchZoom(true)
        barChart.data.setDrawValues(false)

    }
}
