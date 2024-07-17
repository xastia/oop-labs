package com.example.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

open class EllipseShape(): Shape() {
    override var xStart: Float = 0f
    override var yStart: Float = 0f
    override var xEnd: Float = 0f
    override var yEnd: Float = 0f

    override var paint = Paint()
    override var isTouching: Boolean = false

    init {
        paint.strokeWidth = 8f


    }

    override fun setCoordinates(x: Float, y: Float) {

        xStart = x
        yStart = y
        xEnd = x
        yEnd = y

    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.style = Paint.Style.STROKE
        canvas.drawOval(xStart, yStart, xEnd, yEnd, paint)
        paint.color = Color.BLACK



    }

    override fun update(newX: Float, newY: Float) {
        xEnd = newX
        yEnd = newY

    }
}