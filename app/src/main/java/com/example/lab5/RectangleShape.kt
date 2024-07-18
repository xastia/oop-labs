package com.example.lab5

import android.graphics.Canvas
import android.graphics.Paint

open class RectangleShape() :Shape() {
    override var name: String = "Прямокутник"

    override var xStart: Float = 0f
    override var yStart: Float = 0f
    override var xEnd: Float = 0f
    override var yEnd: Float = 0f

    override var paint = Paint()
    override var isTouching: Boolean = false
    init {
        paint.strokeWidth = 8f
        paint.color = 0xFF000000.toInt()
        paint.style = Paint.Style.STROKE


    }

    override fun setCoordinates(x: Float, y: Float) {
        xStart = x
        yStart = y
        xEnd = x
        yEnd = y
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        //paint.color = 0xFF000000.toInt()
        paint.style = Paint.Style.STROKE

        canvas.drawRect(2*xStart - xEnd, 2*yStart - yEnd, xEnd, yEnd, paint)

        //canvas.drawRect(2*xStart - xEnd, 2*yStart - yEnd, xEnd, yEnd, paint)


    }

    override fun update(newX: Float, newY: Float) {
        xEnd = newX
        yEnd = newY

    }


}