package com.acme.tipcalculator.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.EditText
import com.acme.tipcalculator.R

class SaveDialogFragment : DialogFragment() {

    interface Callback{
        fun onSaveTip(name: String)
    }

    //nullable as only exists when we are attached to an activity
    private var saveTipCallback: SaveDialogFragment.Callback? = null

    //as long as the activity has implemented the interface, this will cast context to callback
    //if it hasn't, callback will be null
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        saveTipCallback = context as? Callback
    }

    //set back to null on detach
    override fun onDetach() {
        super.onDetach()
        saveTipCallback = null
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val saveDialog = context?.let { ctx ->

            val editText = EditText(ctx)
            editText.id = viewId
            editText.hint = getString(R.string.save_dialog_fragment_hint_text)

            AlertDialog.Builder(ctx)
                .setView(editText)
                .setNegativeButton(getString(R.string.cancel_button_text), null)
                .setPositiveButton(getString(R.string.save_button_text), {_,_ -> onSave(editText)})
                .create()

        }

        return saveDialog!!


    }

    private fun onSave(editText: EditText) {
        val text : String = editText.text.toString()
        if(text.isNotEmpty()) {
            saveTipCallback?.onSaveTip(text)
        }
    }

    companion object {
        val viewId = View.generateViewId()
    }
}