package com.acme.tipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import com.acme.tipcalculator.R
import com.acme.tipcalculator.model.RestaurantCalculator
import com.acme.tipcalculator.model.TipCalculation

class CalculatorViewModel(val app: Application, val calculator: RestaurantCalculator = RestaurantCalculator() ) : BaseObservable() {

    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputTotalDollarAmount = ""

    init {

        updateOutputs(TipCalculation())

    }

    private fun updateOutputs(tc : TipCalculation){

        outputCheckAmount = app.getString(R.string.dollar_amount, tc.checkAmount)
        outputTipAmount = app.getString(R.string.dollar_amount,tc.tipAmount)
        outputTotalDollarAmount = app.getString(R.string.dollar_amount,tc.grandTotal)
    }


    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if(checkAmount != null && tipPct != null){
            updateOutputs(calculator.calculateTip(checkAmount, tipPct))
            notifyChange()
        }
        clearInputs()

    }

    fun clearInputs(){

        inputCheckAmount="0.00"
        inputTipPercentage="0.00"
        notifyChange()


    }

}