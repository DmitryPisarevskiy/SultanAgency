package com.example.sultanagency.presentation

import java.text.DecimalFormat

fun formatInt(n: Int) =
    DecimalFormat("#,###")
        .format(n)
        .replace(",", " ")

fun formatFloat(n: Float) =
    "%.1f".format(n)