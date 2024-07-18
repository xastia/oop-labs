package com.example.lab5

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lab5.databinding.TableBinding
import kotlin.math.floor


class Table(context: Context): Fragment() {
    private var fragmentBinding: TableBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = TableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }



    fun addRow(shape: Shape) {
        val tableRow = TableRow(context)
        val xS = floor (shape.xStart * 100.0)/100.0
        val yS = floor (shape.yStart * 100.0)/100.0
        val xE = floor (shape.xEnd * 100.0)/100.0
        val yE = floor (shape.yEnd * 100.0)/100.0

        val textViewName = createTextView(shape.name)
        val textViewXStart = createTextView(xS.toString())
        val textViewYStart = createTextView(yS.toString())
        val textViewXEnd = createTextView(xE.toString())
        val textViewYEnd = createTextView(yE.toString())
        tableRow.addView(textViewName)
        tableRow.addView(textViewXStart)
        tableRow.addView(textViewYStart)
        tableRow.addView(textViewXEnd)
        tableRow.addView(textViewYEnd)


        for (i in 0..tableRow.childCount) {
            val textView: TextView? = tableRow.getChildAt(i) as TextView?
            textView?.setTextColor(Color.WHITE)
            textView?.textSize = 13F

        }

        val fragment1Layout = fragmentBinding?.fragment1
        fragment1Layout?.addView(tableRow)



    }
    private fun createTextView(text: String): TextView {
        val textView = TextView(context)
        textView.text = text
        textView.gravity = Gravity.CENTER
        textView.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 7f)
        return textView
    }
}