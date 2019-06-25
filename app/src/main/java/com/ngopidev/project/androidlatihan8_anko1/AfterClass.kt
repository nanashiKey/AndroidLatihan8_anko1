package com.ngopidev.project.androidlatihan8_anko1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.loginafter.*


/**
 *   created by Irfan Assidiq on 2019-06-12
 *   email : assidiq.irfan@gmail.com
 **/
class AfterClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginafter)
        val ambilData = intent.getStringExtra("nama")
        tv_after.text = ambilData
    }
}