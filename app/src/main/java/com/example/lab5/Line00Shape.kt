package com.example.lab5

import android.graphics.Canvas
import android.graphics.Paint

class Line00Shape(): LineShape() {
    override var name: String = "Лінія00"
    override fun draw(canvas: Canvas, paint: Paint) {
        var size = 20f
        //paint.color = 0xFFFFC0CB.toInt()
        canvas.drawLine(xStart, yStart, xEnd, yEnd, paint)
        paint.style = Paint.Style.FILL

        canvas.drawCircle(xStart, yStart , size, paint)
        canvas.drawCircle(xEnd, yEnd, size, paint)
    }
}