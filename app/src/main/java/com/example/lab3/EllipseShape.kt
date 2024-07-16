package com.example.lab3

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class EllipseShape (xStart: Float, yStart: Float, xEnd: Float, yEnd: Float) :Shape(xStart, yStart, xEnd, yEnd) {
    override var paint = Paint()
    override var paint1 = Paint()

    init {
        paint.strokeWidth = 8f
        paint1.strokeWidth = 8f
        paint1.style = Paint.Style.STROKE

    }

    override fun draw(canvas: Canvas) {
        canvas.drawOval(xStart, yStart, xEnd, yEnd, paint1)


    }

    override fun update(newX: Float, newY: Float) {
        paint1.color = Color.RED
        paint.color = Color.RED
        xEnd = newX
        yEnd = newY

    }

}