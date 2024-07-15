package com.example.lab2

import android.graphics.Color

class LineEditor(private var shapeList: MutableList<Shape>):Editor() {
    private var xStart = 0f
    private var yStart = 0f
    private var xEnd = 0f
    private var yEnd = 0f

    private var isTouching = false
    override var currentShape: Shape? = null

    override fun onLBDown(x: Float, y: Float) {
        xStart = x
        yStart = y
        xEnd = x
        yEnd = y

        currentShape = LineShape(xStart, yStart, xEnd, yEnd)

        isTouching = true


    }

    override fun onLBUp(x: Float, y: Float) {
        shapeList.add(LineShape(xStart, yStart, xEnd, yEnd))
        isTouching = false
        currentShape?.paint?.color = Color.BLACK
        currentShape = null
    }

    override fun onMouseMove(x: Float, y: Float) {
        if(isTouching) {
            xEnd = x
            yEnd = y
            currentShape?.update(xEnd, yEnd)
        }
    }
}