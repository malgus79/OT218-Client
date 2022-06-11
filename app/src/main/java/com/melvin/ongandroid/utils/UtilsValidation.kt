package com.melvin.ongandroid.utils

import android.content.Context
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.regex.Pattern

private const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"
private val passPattern = Pattern.compile(PASSWORD_PATTERN)

// Validate if the field is not empty, have a minimum length of 5 characters
// (3 firstname + 1 space + 1 lastname = 5 totals) and are only letters
fun String.validateFormatName() = this.length >= 5 && this.isNotEmpty()

// Validate format email (Patterns.java)
fun String.validateFormatEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

//Validate at least one digit, at least one lowercase, at least one uppercase,
//at least one special character and length between 8-20
fun String.validateFormatPassword(): Boolean = passPattern.matcher(this).matches()

// Validate format not empty and a minimum of 10 characters
fun String.validateFormatQueryMessage(): Boolean = this.isNotEmpty() && this.length >= 10

// Method to hide the keyboard
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}


