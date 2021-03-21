package com.tom.baseandroid.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import java.util.*

object Utils {
    fun hideKeyboard(context: Context) {
        val imm =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val windowHeightMethod =
                InputMethodManager::class.java.getMethod("getInputMethodWindowVisibleHeight")
        val height = windowHeightMethod.invoke(imm) as Int
        if (height > 0) imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    fun languageDefault() =
            if (Locale.getDefault().language != "en" && Locale.getDefault().language != "vn") "en"
            else Locale.getDefault().language

}