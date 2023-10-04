package ru.mggtk.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val emailText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val nameText: EditText = findViewById(R.id.editTextName)
        val ageText: EditText = findViewById(R.id.editTextAge)

        val tv1: TextView = findViewById(R.id.change1)
        val tv2: TextView = findViewById(R.id.change2)
        val tv3: TextView = findViewById(R.id.change3)

        val arguments: Bundle? = intent.extras
        val arguments1: Bundle? = intent.extras

        if (arguments1 != null) {
            val count = arguments?.getInt("count").toString().toInt()
            if (count == 1) {
                if (arguments != null) {
                    val email: String = arguments.getString("email").toString()
                    val name: String = arguments.getString("name").toString()
                    val age: String = arguments.getInt("age").toString()

                    emailText.setText(email)
                    nameText.setText(name)
                    ageText.setText(age)
                    tv1.setText("*")
                    tv2.setText("*")
                    tv3.setText("*")
                }
            }
        }
    }



    fun btnClick(view: View) {

        val email: EditText = findViewById(R.id.editTextTextEmailAddress)
        val name: EditText = findViewById(R.id.editTextName)
        val age: EditText = findViewById(R.id.editTextAge)

        val intent: Intent = Intent(this@MainActivity, InfoActivity::class.java)

        intent.putExtra("email", email.text.toString())
        intent.putExtra("name", name.text.toString())
        intent.putExtra("age", age.text.toString().toInt())

        when(view.id){
            R.id.button -> startActivity(intent)
        }
    }
}