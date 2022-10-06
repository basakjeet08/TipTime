package com.basakjeet08.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.basakjeet08.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    // viewGroup Binding variable which will be used to call the Views Directly and use their Properties
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ViewBinding Setup to the Activity_main layout and showing the layout root
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }
    private fun calculateTip(){
        // Add a case for null value in the text
        val inputCost = binding.cost.text.toString().toDouble()
        val percentage = when(binding.radioGroup.checkedRadioButtonId){
            R.id.amazingButton -> 20.0
            R.id.goodButton -> 15.0
            else -> 10.0
        }
        val tip = (inputCost*percentage )/100.0
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.Tip , formattedTip)
    }
}