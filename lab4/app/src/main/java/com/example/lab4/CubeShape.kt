package com.example.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.math.abs

class CubeShape(): RectangleShape() {


    override fun draw(canvas: Canvas, paint: Paint) {
        val dx = abs(xStart - xEnd) / 2
        val dy = abs(yStart - yEnd)
        paint.style = Paint.Style.STROKE
        paint.color = Color.MAGENTA

        canvas.drawRect(2 * xStart - xEnd, 2 * yStart - yEnd, xEnd, yEnd, paint)
        canvas.drawRect(2 * xStart - xEnd + dx, 2 * yStart - yEnd - dy, xEnd + dx, yEnd - dy, paint)
        canvas.drawLine(2 * xStart - xEnd, 2 * yStart - yEnd, 2 * xStart - xEnd + dx, 2 * yStart - yEnd - dy, paint)
        canvas.drawLine(xEnd, yEnd, xEnd + dx, yEnd - dy, paint)
        canvas.drawLine(2 * xStart - xEnd, yEnd, 2 * xStart - xEnd + dx, yEnd - dy, paint)
        canvas.drawLine(xEnd, 2 * yStart - yEnd, xEnd + dx, 2 * yStart - yEnd - dy, paint)
        paint.color = Color.BLACK
    }


}