package com.example.lab3

abstract class Editor {
    abstract var currentShape: Shape?


    abstract fun onLBDown(x: Float, y: Float)
    abstract fun onLBUp(x: Float, y: Float)
    abstract fun onMouseMove(x: Float, y: Float)
}