package com.ngopidev.project.androidlatihan8_anko1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_act.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.error
import org.jetbrains.anko.toast


/**
 *   created by Irfan Assidiq on 2019-06-12
 *   email : assidiq.irfan@gmail.com
 **/
class Registrasi :AppCompatActivity(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_act)

        btn_regis.setOnClickListener{
            val name = et_inputName.text.toString().trim()
            val pass =  et_inputPassword.text.toString().trim()
            handlingForRegister(name, pass)
        }
    }
    private fun handlingForRegister(uname : String, pass : String){
        when{
            uname.isEmpty() ->{
                toast("username kosong")
                error { "username kosong" }
            }
            pass.isEmpty() -> toast("password kosong")
            else -> alert(title = "REGISTRASI", message = "User Berhasil Registrasi"){
                positiveButton(buttonText = "OK"){
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
        }
    }

}