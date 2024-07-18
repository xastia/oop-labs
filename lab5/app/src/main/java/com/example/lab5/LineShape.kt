package com.example.lab5

import android.graphics.Canvas
import android.graphics.Paint


open class LineShape() :Shape() {
    override var name: String = "Лінія"

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
       // paint.color = 0xFF0000FF.toInt()
        paint.style = Paint.Style.STROKE
        canvas.drawLine(xStart, yStart, xEnd, yEnd, paint)

    }


    override fun update(newX: Float, newY: Float) {

       // paint.color = 0xFFFF0000.toInt()
        xEnd = newX
        yEnd = newY

    }
}