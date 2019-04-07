package com.example.ticketz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logingBtn = findViewById<View>(R.id.LogBtn) as Button

        logingBtn.setOnClickListener(View.OnClickListener {
            view -> loging()
        })
    }

    private fun loging () {

        val emailTxt = findViewById<View>(R.id.UserTxt) as EditText
        val passTxt = findViewById<View>(R.id.PassTxt) as EditText

        var email = emailTxt.text.toString()
        var password = passTxt.text.toString()

        if (!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, {task ->
                if (task.isSuccessful){
                    startActivity(Intent())
                }
            })

        } else {
            Toast.makeText( this, "Agregar usuario y contraseña!", Toast.LENGTH_LONG).show()
        }
    }


}
