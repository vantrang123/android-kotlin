package com.tom.baseandroid.utils

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.AbsoluteSizeSpan
import android.view.inputmethod.InputMethodManager
import com.tom.baseandroid.extensions.dp
import com.tom.baseandroid.extensions.sp
import com.tom.baseandroid.utils.Constants.CURRENCY_VND
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

    fun spanSize(s1: String, s2: String): String {
        val span1 = SpannableString(s1)
        span1.setSpan(AbsoluteSizeSpan(8.sp, false), 0, s1.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        val span2 = SpannableString(s2)
        span2.setSpan(AbsoluteSizeSpan(13.sp, false), 0, s2.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        return TextUtils.concat(span1, span2).toString()
    }
}