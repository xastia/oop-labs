package com.example.lab4

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Line00Shape(): LineShape() {

    override fun draw(canvas: Canvas, paint: Paint) {
        var size = 20f
        paint.color = Color.GREEN
        canvas.drawLine(xStart, yStart, xEnd, yEnd, paint)
        paint.style = Paint.Style.FILL

        canvas.drawCircle(xStart, yStart , size, paint)
        canvas.drawCircle(xEnd, yEnd, size, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
    }
}