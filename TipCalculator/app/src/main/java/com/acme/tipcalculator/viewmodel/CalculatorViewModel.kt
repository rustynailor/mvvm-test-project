package com.acme.tipcalculator.viewmodel

import android.databinding.BaseObservable
import com.acme.tipcalculator.model.RestaurantCalculator
import com.acme.tipcalculator.model.TipCalculation

class CalculatorViewModel(val calculator: RestaurantCalculator = RestaurantCalculator() ) : BaseObservable() {

    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var tipCalculation = TipCalculation()

    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if(checkAmount != null && tipPct != null){
            tipCalculation = calculator.calculateTip(checkAmount, tipPct)
        }
        clearInputs()

    }

    fun clearInputs(){

        inputCheckAmount="0.00"
        inputTipPercentage="0.00"
        notifyChange()


    }

}