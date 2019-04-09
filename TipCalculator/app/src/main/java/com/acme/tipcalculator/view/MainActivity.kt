package com.acme.tipcalculator.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle

import android.support.v7.app.AppCompatActivity;


import com.acme.tipcalculator.R

import com.acme.tipcalculator.viewmodel.CalculatorViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding : com.acme.tipcalculator.databinding.MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = setContentView(this, R.layout.main_activity)
        binding.vm = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)


        setSupportActionBar(binding.toolbar)



    }

}
