package com.ngopidev.project.androidlatihan8_anko1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            val username = et_username.text.toString().trim()
            val pass = et_pass.text.toString().trim()
            handlingForLogin(username, pass)
        }

        tv_regis.setOnClickListener {
            toast("Pindah Ke halaman Register") //cara membuat toast pada anko
            startActivity(intentFor<Registrasi>()) //kalo kotlin biasa :
                                                    //startActivity(Intent(this@MainActivity, Registrasi::class.java))
        }
    }

    private fun handlingForLogin(uname : String, pass : String){
            info{"username = $uname , password = $pass"}
            if(uname.equals("master") && pass.equals("master123")){
                toast("Welcome $uname")
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
