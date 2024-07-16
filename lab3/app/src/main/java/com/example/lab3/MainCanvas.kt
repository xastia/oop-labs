package com.example.lab3

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

 class MainCanvas (context: Context, attrs: AttributeSet): View(context, attrs) {
    private var shapeList: MutableList<Shape> = mutableListOf()
    private var currentEditor: Editor? = null
    private var currentShape: Shape? = null


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        shapeList.forEach{
            it.draw(canvas)
        }

        if(currentShape != null) {
            currentShape!!.draw(canvas)
        }
    }

    fun setEditor(shape: Enum) {
        currentEditor = when (shape) {
            Enum.Line -> LineEditor(shapeList)
            Enum.Point -> PointEditor(shapeList)
            Enum.Rectangle -> RectangleEditor(shapeList)
            Enum.Ellipse -> EllipseEditor(shapeList)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                currentEditor?.onLBDown(event.x, event.y )
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                currentEditor?.onMouseMove(event.x, event.y)
                currentShape = currentEditor?.currentShape
                invalidate()
            }

            MotionEvent.ACTION_UP -> {
                currentEditor?.onLBUp(event.x, event.y)
                invalidate()

            }
        }
        return true
    }
}