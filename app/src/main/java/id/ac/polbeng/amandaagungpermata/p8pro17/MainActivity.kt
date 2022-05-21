package id.ac.polbeng.amandaagungpermata.p8pro17

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filename = "$packageName TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        btnSave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("lastname", inputLastName.text.toString())
            editor.putString("firstname", inputFirstName.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved data", Toast.LENGTH_SHORT).show()
        }

        btnLoad.setOnClickListener {
            val mlastname = pref.getString("lastname", "")
            val mfirstname = pref.getString("firstname", "")
            val moutput = "$mfirstname $mlastname"
            tvName.text = moutput
        }

        btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        inputFirstName.setText("")
        inputLastName.setText("")
        tvName.setText("")
    }

}