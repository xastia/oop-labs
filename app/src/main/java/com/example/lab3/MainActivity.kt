package com.example.lab3


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lab3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mainCanvas: MainCanvas
    private lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root)}
        super.onCreate(savedInstanceState)

        mainCanvas = bindingClass.mainCanvas

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
                mainCanvas.setEditor(com.example.lab3.Enum.Line)
                return true
            }
            R.id.ellipse -> {
                supportActionBar?.title = resources.getString(R.string.ellipse)
                mainCanvas.setEditor(com.example.lab3.Enum.Ellipse)
                return true
            }
            R.id.rectangle -> {
                supportActionBar?.title = resources.getString(R.string.rectangle)
                mainCanvas.setEditor(com.example.lab3.Enum.Rectangle)
                return true
            }
            R.id.point -> {
                supportActionBar?.title = resources.getString(R.string.point)
                mainCanvas.setEditor(com.example.lab3.Enum.Point)
                return true
            }
        }
        return true


    }




}