package com.tom.baseandroid.ui.customview

import android.app.Dialog
import android.content.Context
import com.tom.baseandroid.R

class LoadingProgress(context: Context) : Dialog(context, R.style.ProgressDialog) {

    private var countLoading = 0

    init {
        initLoadingProgress()
    }

    private fun initLoadingProgress() {
        this.setContentView(R.layout.loading_progress)
        this.setCancelable(false)
        this.setCanceledOnTouchOutside(false)
    }

    override fun show() {
        try {
            if (countLoading == 0) {
                super.show()
            }
            countLoading++
        } catch (e: Exception) {
        }
    }

    override fun dismiss() {
        countLoading--
        if (countLoading > 0 || !super.isShowing()) return
        super.dismiss()
    }

    fun forceDismiss() {
        countLoading = 0
        super.dismiss()
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        dismiss()
//    }
}