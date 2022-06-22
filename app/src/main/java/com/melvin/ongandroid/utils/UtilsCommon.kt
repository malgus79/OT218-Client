package com.melvin.ongandroid.utils

import android.content.Context
import android.text.Html
import android.view.View
import android.view.inputmethod.InputMethodManager

// Method to hide the keyboard
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

// Convert HTML to string
fun String?.convertHtmlToString(): String {
    if (this == null)
        return ""
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(this).toString()
    }
}