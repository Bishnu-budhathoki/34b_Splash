package com.example.a34b_splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a34b_splash.databinding.FragmentDestinationBinding


class DestinationFragment : Fragment() {
    lateinit var destinationBinding: FragmentDestinationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        destinationBinding= FragmentDestinationBinding
            .inflate(inflater,container,false)

        var a= arguments?.getInt("first").toString().toInt()
        var b= arguments?.getInt("second").toString().toInt()

        var result = a+b

        destinationBinding.resultText.text="the sum of $a and $b is $result"
        return destinationBinding.root
    }


}