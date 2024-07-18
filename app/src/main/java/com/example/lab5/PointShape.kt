package com.example.lab5

import android.graphics.Canvas
import android.graphics.Paint

class PointShape(): Shape() {
    override var name: String = "Крапка"

    override var xStart: Float = 0f
    override var yStart: Float = 0f
    override var xEnd: Float = 0f
    override var yEnd: Float = 0f

    override var paint = Paint()
    override var isTouching: Boolean = false

    init {
        paint.strokeWidth = 14f
        //paint.color = 0xFF000000.toInt()
    }

    override fun setCoordinates(x: Float, y: Float) {
        xStart = x
        yStart = y
        xEnd = x
        yEnd = y
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawPoint(xStart, yStart, paint)
    }

    override fun update(newX: Float, newY: Float) {
        xEnd = newX
        yEnd = newY
    }
}