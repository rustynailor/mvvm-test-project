package com.acme.tipcalculator.model

import java.math.RoundingMode

class RestaurantCalculator {

    fun calculateTip(checkAmount: Double, tipPct: Int) : TipCalculation {

        val tipAmount = (checkAmount * (tipPct.toDouble() / 100.0))
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .toDouble()

        val grandTotal = checkAmount + tipAmount

        return TipCalculation(
            checkAmount = checkAmount,
            tipPct = tipPct,
            grandTotal = grandTotal,
            tipAmount = tipAmount

        )
    }
}