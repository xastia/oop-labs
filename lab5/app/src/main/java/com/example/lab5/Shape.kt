package com.example.lab5

import android.graphics.Canvas
import android.graphics.Paint


abstract class Shape() {
    abstract var name: String

    abstract var xStart: Float
    abstract var yStart: Float
    abstract var xEnd: Float
    abstract var yEnd: Float

    abstract var paint: Paint
    abstract var isTouching: Boolean

    abstract fun draw(canvas: Canvas, paint: Paint)
    abstract fun setCoordinates (x: Float, y: Float)

    abstract fun update(newX: Float, newY: Float)



}