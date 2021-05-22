package com.example.submission3jetpack.utils

import java.text.SimpleDateFormat
import java.util.*

object Convert {

     fun runtimeToHours(runtime: Int): String {
        val hours = runtime / 60
        val minutes = runtime % 60
        return "$hours hours $minutes minutes"
    }

    fun convertStringToDate(date: String): String{
        var format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val convertedDate = format.parse(date)

        format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val currentDate = format.format(convertedDate as Date)

        return currentDate.toString()
    }
}