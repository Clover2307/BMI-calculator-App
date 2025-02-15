package com.example.a1cet3013n

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class AboutDialog:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val about_dialog = AlertDialog.Builder(requireContext())
            .setTitle("About")
            .setMessage("Body mass index (BMI) Version 1.0")
            .setPositiveButton("OK") {dialog,which ->}
            .create()
        return about_dialog
    }
}