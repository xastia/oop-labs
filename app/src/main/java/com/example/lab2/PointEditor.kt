package com.example.lab2

class PointEditor(private var shapeList: MutableList<Shape>) :Editor() {
    private var xStart = 0f
    private var yStart = 0f
    private var xEnd = 0f
    private var yEnd = 0f




    override var currentShape: Shape? = null

    override fun onLBDown(x: Float, y: Float) {
        xStart = x
        yStart = y
        xEnd = x
        yEnd = y
    }

    override fun onMouseMove(x: Float, y: Float) {
        xEnd = x
        yEnd = y
    }

    override fun onLBUp(x: Float, y: Float) {
        shapeList.add(PointShape(xStart, yStart, xStart, yStart) )
    }


}