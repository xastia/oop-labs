package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lab4.databinding.ActivityMainBinding
import kotlin.math.E

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private lateinit var mainCanvas: MainCanvas
    private lateinit var myEditor: MyEditor
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root)}
        super.onCreate(savedInstanceState)

        mainCanvas = bindingClass.mainCanvas
        myEditor = mainCanvas.myEditor
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2, menu)
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId) {

            R.id.line -> {
                supportActionBar?.title = resources.getString(R.string.line)
                myEditor.currentShape = LineShape()
                return true
            }
            R.id.ellipse -> {
                supportActionBar?.title = resources.getString(R.string.ellipse)
                myEditor.currentShape = EllipseShape()
                return true
            }
            R.id.rectangle -> {
                supportActionBar?.title = resources.getString(R.string.rectangle)
                myEditor.currentShape = RectangleShape()
                return true
            }
            R.id.point -> {
                supportActionBar?.title = resources.getString(R.string.point)
                myEditor.currentShape = PointShape()
                return true
            }
            R.id.cube -> {
                supportActionBar?.title = resources.getString(R.string.cube)
                myEditor.currentShape = CubeShape()
            }
            R.id.line00 -> {
                supportActionBar?.title = resources.getString(R.string.line00)
                myEditor.currentShape = Line00Shape()
            }
        }
        return true


    }

}