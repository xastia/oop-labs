package com.example.lab5

import android.graphics.Canvas
import android.graphics.Paint

class EllipseShape(): Shape() {
    override var name: String = "Еліпс"

    override var xStart: Float = 0f
    override var yStart: Float = 0f
    override var xEnd: Float = 0f
    override var yEnd: Float = 0f

    override var paint = Paint()
    override var isTouching: Boolean = false

    init {
        paint.strokeWidth = 8f
        // paint1.strokeWidth = 8f
        // paint1.style = Paint.Style.STROKE

    }

    override fun setCoordinates(x: Float, y: Float) {
        xStart = x
        yStart = y
        xEnd = x
        yEnd = y
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.STROKE
       // paint.color = 0xFF000000.toInt()
        canvas.drawOval(xStart, yStart, xEnd, yEnd, paint)


    }

    override fun update(newX: Float, newY: Float) {
        //paint1.color = 0xFFFF0000.toInt()
        //paint.color = 0xFFFF0000.toInt()
        xEnd = newX
        yEnd = newY

    }
}