package com.vppanchaofficial.progresstimer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var progress_circular: ProgressBar
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress_circular = findViewById(R.id.progress_circular);
        var progress_value = findViewById<TextView>(R.id.progress_value);

        val SHOW_PROGRESS = findViewById<Button>(R.id.SHOW_PROGRESS).setOnClickListener {

            //This is for increase progress by 10%

            /*if(counter <= 90) {
                counter += 10;
                progress_value.text = counter.toString() + " %"
                progress_circular.setProgress(counter);
            }else{
                progress_value.text = "Progress Completed"
            }*/


            //Code for increase progress with time

            val twoMin = 1 * 60 * 1000 // minutes in milli seconds
            progress_circular.max = twoMin / 1000

            object : CountDownTimer(twoMin.toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val seconds: Long = millisUntilFinished / 1000

                    //var seconds = (millisUntilFinished /1000).toInt()
                    //progress_value.text =  Math.round(millisUntilFinished * 0.001f).toString()
                    //val barVal: Int = progress_circular.max - ((seconds / 60 * 100).toInt() + (seconds % 60).toInt())
                    //progress_circular.progress = barVal

                    progress_value.text =  String.format(
                        "%02d",
                        seconds / 60
                    ) + ":" + String.format("%02d", seconds % 60)
                    progress_circular.progress = Math.round(millisUntilFinished * 0.001f)

                }

                override fun onFinish() {
                    // DO something when minutes is up
                    progress_circular.progress = 0
                }
            }.start()
        }
    }
}