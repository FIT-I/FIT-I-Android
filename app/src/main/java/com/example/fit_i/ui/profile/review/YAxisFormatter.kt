package com.example.fit_i.ui.profile.review

import com.github.mikephil.charting.formatter.ValueFormatter

class YAxisFormatter : ValueFormatter() {

    override fun getFormattedValue(value: Float): String {
        return value.toInt().toString()
    }
}
