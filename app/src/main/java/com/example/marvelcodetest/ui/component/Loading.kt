package com.example.marvelcodetest.ui.component

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import com.example.marvelcodetest.R
import com.example.marvelcodetest.databinding.LayoutProgressBarBinding

class Loading(val context: Context) {

    private val progressDialog: Dialog = createProgressDialog()
    private lateinit var binding : LayoutProgressBarBinding

    fun show() {
        progressDialog.show()
    }

    fun hide() {
        progressDialog.dismiss()
    }

    private fun createProgressDialog() = Dialog(context, R.style.ProgressBarTheme).apply {
        binding = LayoutProgressBarBinding.inflate(LayoutInflater.from(context))
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        window?.setBackgroundDrawableResource(R.color.progress_bar_bg)
        setContentView(binding.root)
    }

}