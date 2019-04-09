package com.acme.tipcalculator.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry


abstract class ObservableViewModel(app: Application) : AndroidViewModel(app), Observable {


    @delegate:Transient
    private val mCallbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallbacks.remove(callback)
    }

    //passing 0 as propertyId indicates all have changed
    //we use a constant for this
    fun notifyChange() {
        mCallbacks.notifyChange( this, 0)
    }

 }