package com.acme.tipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import com.acme.tipcalculator.R
import com.acme.tipcalculator.model.RestaurantCalculator
import com.acme.tipcalculator.model.TipCalculation

class CalculatorViewModel @JvmOverloads constructor(
    app: Application, val calculator: RestaurantCalculator = RestaurantCalculator() ) : ObservableViewModel(app) {

    private var lastTipCalculated = TipCalculation()

    var inputCheckAmount = ""
    var inputTipPercentage = ""

    val outputCheckAmount get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculated.checkAmount)
    val outputTipAmount get()  = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculated.tipAmount)
    val outputTotalDollarAmount get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculated.grandTotal)
    val locationName get() = lastTipCalculated.locationName


    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc : TipCalculation){

        lastTipCalculated = tc
        notifyChange()

    }


    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if(checkAmount != null && tipPct != null){
            updateOutputs(calculator.calculateTip(checkAmount, tipPct))
        }
        clearInputs()

    }

    fun clearInputs(){

        inputCheckAmount="0.00"
        inputTipPercentage="0.00"
        notifyChange()
    }

    fun saveCurrentTip(name: String){
        val tipToSave = lastTipCalculated.copy(locationName = name)//current TipCalculation with locationName added

        calculator.saveTipCalculation(tipToSave)
        updateOutputs(tipToSave)
        notifyChange()
    }

}