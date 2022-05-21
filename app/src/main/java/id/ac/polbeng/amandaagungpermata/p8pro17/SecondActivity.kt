package id.ac.polbeng.amandaagungpermata.p8pro17

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnLoadData.setOnClickListener {
            val filename = "$packageName TESTFILE"
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val lastname = pref.getString("lastname", "")
            val firstname = pref.getString("firstname", "")
            tvNameNext.text = "$firstname $lastname "

        }
    }

    override fun onResume() {
        super.onResume()
        tvNameNext.text = "Click 'LOAD DATA'"
    }
}