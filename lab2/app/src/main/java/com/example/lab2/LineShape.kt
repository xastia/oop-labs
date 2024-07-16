package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class LineShape(xStart: Float, yStart: Float, xEnd: Float, yEnd: Float) :Shape(xStart, yStart, xEnd, yEnd) {
    override var paint = Paint()
    override var paint1 = Paint()

    init {
        paint.strokeWidth = 8f

    }

    override fun draw(canvas: Canvas) {
        canvas.drawLine(xStart, yStart, xEnd, yEnd, paint)

    }

    override fun update(newX: Float, newY: Float) {
        paint.color = Color.BLUE
        xEnd = newX
        yEnd = newY

    }
}