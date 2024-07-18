package com.example.lab5

import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.PathEffect

class MyEditor {
    private var shapesList = mutableListOf<Shape>()
    private var endShapes: MutableList<Shape> = mutableListOf()
    var currentShape: Shape? = null
    private var temporaryShape: Shape? = null
    private val gumTraceColor = 0xFF000000.toInt()
    private lateinit var newShape: Shape
    private val paint = Paint()
    //private var table: Table = Table()
    private lateinit var table1: Table
    fun onDraw(canvas: Canvas) {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f
        paint.color = 0xFF000000.toInt()
        paint.pathEffect = PathEffect()

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
        table1.addRow(newShape)
        endShapes.add(newShape)
        temporaryShape = null
    }

     fun getTable(table: Table) {
        table1 = table
    }

    fun getShapes(): MutableList<Shape> {
        return endShapes
    }


    companion object{
        private var instance: MyEditor? = null

        fun getInstance(): MyEditor {
            if (instance == null) {
                instance = MyEditor()
            }
            return instance!!
        }
    }


}