package com.example.a34b_splash

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a34b_splash.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {
    lateinit var destinationBinding: ActivityDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        destinationBinding=ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(destinationBinding.root)

        var name:String=intent.getStringExtra("name").toString()
        var phone:String=intent.getStringExtra("phone").toString()

        intent.putExtra("name",name)
        intent.putExtra("phone",phone)


        startActivity(intent)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}