package com.acme.tipcalculator.viewmodel

import com.acme.tipcalculator.model.RestaurantCalculator
import com.acme.tipcalculator.model.TipCalculation

class CalculatorViewModel(val calculator: RestaurantCalculator = RestaurantCalculator() ) {

    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var tipCalculation = TipCalculation()

    fun calculateTio() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct :

    }

}