package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private lateinit var mainCanvas: MainCanvas
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root)}
        super.onCreate(savedInstanceState)

         mainCanvas = bindingClass.mainCanvas

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.line -> {
                supportActionBar?.title = resources.getString(R.string.line)
                mainCanvas.setEditor(Enum.Line)
                return true
            }
            R.id.ellipse -> {
                supportActionBar?.title = resources.getString(R.string.ellipse)
                mainCanvas.setEditor(Enum.Ellipse)
                return true
            }
            R.id.rectangle -> {
                supportActionBar?.title = resources.getString(R.string.rectangle)
                mainCanvas.setEditor(Enum.Rectangle)
                return true
            }
            R.id.point -> {
                supportActionBar?.title = resources.getString(R.string.point)
                mainCanvas.setEditor(Enum.Point)
                return true
            }
        }
        return true
    }
}