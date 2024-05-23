package com.example.a34b_splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a34b_splash.databinding.ActivitySourceBinding

class SourceActivity : AppCompatActivity() {
    lateinit var sourceBinding: ActivitySourceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sourceBinding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(sourceBinding.root)

        sourceBinding.Button.setOnClickListener {
//            var intent= Intent(this@SourceActivity,
//                DestinationActivity::class.java)
//
//            var name:String=sourceBinding.number1.text.toString()
//            var number : String=sourceBinding.contactnumber.text.toString()
            var a = sourceBinding.number1.text.toString().toInt()
            var b = sourceBinding.contactnumber.text.toString().toInt()
            var bundle = Bundle()

            var destinationFragment = DestinationFragment()

            bundle.putInt("first",a)
            bundle.putInt("second",b)

            destinationFragment.arguments = bundle

//            fragmentTransaction


            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayoutDataPass,destinationFragment)
                .commit()



        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}