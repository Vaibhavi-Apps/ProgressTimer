package com.vppanchaofficial.progresstimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var progress_circular: ProgressBar
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress_circular = findViewById(R.id.progress_circular);
        var progress_value = findViewById<TextView>(R.id.progress_value);

        val SHOW_PROGRESS = findViewById<Button>(R.id.SHOW_PROGRESS).setOnClickListener {
            if(counter <= 90) {
                counter += 10;
                progress_value.text = counter.toString() + " %"
                progress_circular.setProgress(counter);
            }else{
                progress_value.text = "Progress Completed"
            }
        }

    }
}