package com.example.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class PointShape(): Shape() {
    override var xStart: Float = 0f
    override var yStart: Float = 0f
    override var xEnd: Float = 0f
    override var yEnd: Float = 0f

    override var paint = Paint()
    override var isTouching: Boolean = false

    init {
        paint.strokeWidth = 14f

    }

    override fun setCoordinates(x: Float, y: Float) {
        xStart = x
        yStart = y
        xEnd = x
        yEnd = y
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = Color.BLACK
        canvas.drawPoint(xStart, yStart, paint)
    }

    override fun update(newX: Float, newY: Float) {
        xEnd = newX
        yEnd = newY
    }
}