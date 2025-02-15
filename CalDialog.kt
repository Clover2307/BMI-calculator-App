package com.example.a1cet3013n

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CalDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val formulaDialog = AlertDialog.Builder(requireContext())
            .setTitle("BMI Formulas")
            .setMessage("Metric units: weight(kg) / height^2 (meters)"
            +"\n\nImperial units: 703 * weight(lbs) / height^2 (inches)")
            .setPositiveButton("OK") {dialog,which ->}
            .create()
        return formulaDialog
    }
}