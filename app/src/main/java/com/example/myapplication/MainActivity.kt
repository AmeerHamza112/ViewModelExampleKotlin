package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        binding.buttonIncrement.setOnClickListener(this)
        setText()
    }

    fun setText(){
        binding.textViewIncrement.text=mainViewModel.count.toString()
    }

    override fun onClick(v: View?) {
        var id : Int = v!!.id
        if(id==R.id.button_increment) {
            mainViewModel.increment()
            setText()
        }
    }
}