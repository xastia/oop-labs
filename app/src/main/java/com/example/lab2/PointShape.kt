package com.example.lab2

import android.graphics.Canvas
import android.graphics.Paint

class PointShape(override var xStart: Float, override var yStart: Float, xEnd: Float, yEnd: Float) :Shape(xStart, yStart, xEnd, yEnd) {
    override var paint = Paint()
    override var paint1 = Paint()


    init {
        paint.strokeWidth = 14f
    }

    override fun draw(canvas: Canvas) {
        canvas.drawPoint(xStart, yStart, paint)
    }

    override fun update(newX: Float, newY: Float) {
        xEnd = newX
        yEnd = newY
    }
}