package com.example.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.PathEffect

class MyEditor {
    private var shapesList = mutableListOf<Shape>()
    var currentShape: Shape? = null
    private var temporaryShape: Shape? = null
    private val gumTraceColor = Color.BLUE
    private lateinit var newShape: Shape
    private val paint = Paint()

    fun onDraw (canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f
        paint.pathEffect = PathEffect()
        paint.color = gumTraceColor

        for (shape in shapesList) {
            shape.isTouching = false
            shape.draw(canvas, paint)
        }

        paint.pathEffect = DashPathEffect(floatArrayOf(10f, 10f), 0f)
        paint.color = gumTraceColor
        if (temporaryShape != null) {
            temporaryShape!!.isTouching = true
            temporaryShape!!.draw(canvas, paint)
        }
    }

    fun onLBDown(x: Float, y: Float) {
        currentShape = currentShape?.javaClass?.newInstance()
        currentShape?.setCoordinates(x, y)
        temporaryShape = currentShape
    }

    fun onMouseMove(x: Float, y: Float) {
        temporaryShape?.update(x, y)
    }

    fun onLBUp(x: Float, y: Float) {
        newShape = currentShape!!
        shapesList.add(newShape)
        temporaryShape = null
    }
}