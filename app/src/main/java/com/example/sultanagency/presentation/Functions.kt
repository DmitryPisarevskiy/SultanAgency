package com.example.sultanagency.presentation

import java.text.DecimalFormat

fun formatter(n: Int) =
    DecimalFormat("#,###")
        .format(n)
        .replace(",", " ")