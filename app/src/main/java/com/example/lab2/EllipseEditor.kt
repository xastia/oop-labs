package com.example.lab2

import android.graphics.Color
import android.graphics.Paint

class EllipseEditor(private var shapeList: MutableList<Shape>) :Editor() {
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

        currentShape = EllipseShape(xStart, yStart, xEnd, yEnd)
        isTouching = true

    }

    override fun onLBUp(x: Float, y: Float) {
        shapeList.add(EllipseShape(xStart, yStart, xEnd, yEnd))
        isTouching = false
        currentShape?.paint1?.color = Color.BLACK
        currentShape?.paint?.color = Color.WHITE
        currentShape?.paint?.style = Paint.Style.FILL

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