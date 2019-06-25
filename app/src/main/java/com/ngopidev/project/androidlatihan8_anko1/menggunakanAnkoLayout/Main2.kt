package com.ngopidev.project.androidlatihan8_anko1.menggunakanAnkoLayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ngopidev.project.androidlatihan8_anko1.AfterClass
import com.ngopidev.project.androidlatihan8_anko1.R
import com.ngopidev.project.androidlatihan8_anko1.Registrasi
import org.jetbrains.anko.*
import org.w3c.dom.Text


/**
 *   created by Irfan Assidiq on 2019-06-12
 *   email : assidiq.irfan@gmail.com
 **/
class Main2 :AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewLogin().setContentView(this)

        val btn : Button = findViewById(R.id.btn_login)
        val regis : TextView = findViewById(R.id.tv_regis)
        val uname : EditText = findViewById(R.id.et_inputName)
        val pass : EditText = findViewById(R.id.et_inputPassword)

        btn.setOnClickListener {
            val nama = uname.text.toString().trim()
            val password = pass.text.toString().trim()
            handlingForLogin(nama, password)
        }

        regis.setOnClickListener {
            startActivity(intentFor<Registrasi>())
        }
    }

    class ViewLogin : AnkoComponent<Main2>{
        override fun createView(ui: AnkoContext<Main2>) = with(ui) {
            verticalLayout {
                lparams{
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.abu
                }
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent){
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 20
                    }
                    textView {
                        text = "LOGIN"
                        textSize = 25.0f
                        textColor = Color.CYAN
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent){
                        margin = 15
                    }

                    editText {
                        hint = "input your name"
                        id = R.id.et_inputName
                        inputType = InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent){
                        margin = 15
                    }
                    editText {
                        hint = "input Password"
                        id = R.id.et_inputPassword
                        inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                    }.lparams(width = matchParent, height = wrapContent){
                        margin = 15
                    }
                    button("login") {
                        id = R.id.btn_login
                    }.lparams(width = wrapContent, height = wrapContent){
                        margin = 15
                        gravity = Gravity.CENTER
                    }
                    textView {
                        text = "Register !!"
                        id = R.id.tv_regis
                        textSize = 15.0f
                        textColor = Color.BLUE
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent){
                        margin = 15
                    }
                }
            }
        }

    }

    private fun handlingForLogin(uname : String, pass : String){
        info{"username = $uname , password = $pass"}
        if(uname.equals("master") && pass.equals("master123")){
            toast("Welcome $uname")
            startActivity(intentFor<AfterClass>("nama" to uname))
            finish()
        }else{
            alert(title = "Warning", message = "Password atau username salah") {
                positiveButton(buttonText = "OK"){
                    //do nothing
                }
//                    negativeButton(buttonText = "NO"){
//                        //nanti ngapain
//                    }
                isCancelable = false
            }.show()
        }
    }
}