package com.example.lab3

import android.graphics.Canvas
import android.graphics.Paint

abstract class Shape(open var xStart: Float, open var yStart: Float, open var xEnd: Float, open var yEnd: Float) {

    abstract var paint: Paint
    abstract var paint1: Paint

    abstract fun draw(canvas: Canvas)

    abstract fun update(newX: Float, newY: Float)

}