package com.example.myapplication.utils

import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.myapplication.R

object AppFontFamily {

    private val fontsProvider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val Arial = FontFamily(
        Font(googleFont = GoogleFont("Arial"), fontProvider = fontsProvider)
    )
}

