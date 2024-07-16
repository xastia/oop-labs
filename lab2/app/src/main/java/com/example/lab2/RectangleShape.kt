package com.example.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class RectangleShape(xStart: Float, yStart: Float, xEnd: Float, yEnd: Float) :Shape(xStart, yStart, xEnd, yEnd) {
    override var paint = Paint()
    override var paint1 = Paint()

    init {
        paint.strokeWidth = 8f
        paint1.strokeWidth = 8f
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL

    }

    override fun draw(canvas: Canvas) {
        paint1.style = Paint.Style.STROKE
        canvas.drawRect(xStart, yStart, xEnd, yEnd, paint1)

        canvas.drawRect(xStart, yStart, xEnd, yEnd, paint)


    }

    override fun update(newX: Float, newY: Float) {
        paint.style = Paint.Style.STROKE
        paint1.color = Color.BLUE
        paint.color = Color.BLUE
        xEnd = newX
        yEnd = newY

    }


}