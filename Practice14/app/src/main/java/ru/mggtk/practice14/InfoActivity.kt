package ru.mggtk.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val emailText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val nameText: EditText = findViewById(R.id.editTextName)
        val ageText: EditText = findViewById(R.id.editTextAge)

        val arguments: Bundle? = intent.extras

        val email: String = arguments?.getString("email").toString()
        val name: String = arguments?.getString("name").toString()
        val age: String = arguments?.getInt("age").toString()

        if (arguments != null){
            emailText.setText(email)
            nameText.setText(name)
            ageText.setText(age)
        }
    }

    fun btnClick(view: View) {
        val email: EditText = findViewById(R.id.editTextTextEmailAddress)
        val name: EditText = findViewById(R.id.editTextName)
        val age: EditText = findViewById(R.id.editTextAge)

        val intent: Intent = Intent(this@InfoActivity, MainActivity::class.java)

        val count = 1
        intent.putExtra("email", email.text.toString())
        intent.putExtra("name", name.text.toString())
        intent.putExtra("age", age.text.toString().toInt())
        intent.putExtra("count",count)

        when(view.id){
            R.id.button -> startActivity(intent)
        }
    }
}