package com.x5s.room_assignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.x5s.room_assignment.contacts.CategoryActivity

class LoginActivity : AppCompatActivity() {

    private var userViewModel: UserViewModel? = null
    private var usernameText: EditText? = null
    private var passwordText: EditText? = null
    private var loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usernameText = findViewById<View>(R.id.username) as EditText
        passwordText = findViewById<View>(R.id.password) as EditText
        loginButton = findViewById<View>(R.id.login) as Button

        userViewModel = ViewModelProviders.of(this, UserViewModel.Factory(applicationContext)).get(UserViewModel::class.java)

        loginButton!!.visibility = View.VISIBLE

        loginButton!!.setOnClickListener {
            val isValid = userViewModel!!.checkValidLogin(usernameText!!.text.toString(), passwordText!!.text.toString())
            if (isValid) {
                Toast.makeText(baseContext, "Successfully Logged In!", Toast.LENGTH_LONG).show()
                Log.i("Successful_Login", "Login was successful")
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(baseContext, "Invalid Login!", Toast.LENGTH_SHORT).show()
                Log.i("Unsuccessful_Login", "Login was not successful")
            }
        }
    }
}