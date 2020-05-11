package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {


    lateinit var textView: TextView
    lateinit var button : Button
    var viewModelDemo: ViewModelDemo= ViewModelDemo()
    private val isCookieLoadedObserver by lazy {
        Observer<String> {
            textView.setText(it)
            System.out.println("task because of postValue")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView= findViewById(R.id.textView);

        button = findViewById(R.id.button);
        System.out.println("Before registration")
        viewModelDemo.liveData.observe(this,isCookieLoadedObserver)


        button.setOnClickListener { viewModelDemo.postLiveData("ASHOK KUMAR DHULIPALLA") }
        Thread.sleep(5000)
        System.out.println("After registration")


    }
}
