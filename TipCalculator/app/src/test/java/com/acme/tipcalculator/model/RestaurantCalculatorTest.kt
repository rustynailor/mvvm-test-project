package com.acme.tipcalculator.model

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RestaurantCalculatorTest {

    lateinit var calculator: RestaurantCalculator

    @Before
    fun setup(){
        calculator = RestaurantCalculator()
    }

    @Test
    fun testCalculateTip(){

        val checkInput = 10.00
        val tipPctInput = 25

        val expectedTipResult = TipCalculation(
            checkAmount = checkInput,
            tipPct = tipPctInput,
            tipAmount = 2.50,
            grandTotal = 12.50

        )

        assertEquals(expectedTipResult, calculator.calculateTip(checkInput, tipPctInput))
    }

    //example using data class copy
    @Test
    fun testCalculateMultipleTips(){

        val baseTc = TipCalculation( checkAmount = 10.00)
        val testVals = listOf(baseTc.copy(tipPct = 25, tipAmount = 2.5, grandTotal = 12.50),
                        baseTc.copy(tipPct = 15, tipAmount = 1.5, grandTotal = 11.50),
                        baseTc.copy(tipPct = 18, tipAmount = 1.8, grandTotal = 11.80))
        val tipPctInput = 25

        testVals.forEach{
            assertEquals(it, calculator.calculateTip(it.checkAmount, it.tipPct))
        }

    }

}