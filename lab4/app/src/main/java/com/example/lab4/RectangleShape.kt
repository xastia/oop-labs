package com.example.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

open class RectangleShape() :Shape() {
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
        paint.color = Color.YELLOW

        canvas.drawRect(2*xStart - xEnd, 2*yStart - yEnd, xEnd, yEnd, paint)

        canvas.drawRect(2*xStart - xEnd, 2*yStart - yEnd, xEnd, yEnd, paint)
        paint.color = Color.BLACK

    }

    override fun update(newX: Float, newY: Float) {
        xEnd = newX
        yEnd = newY

    }


}