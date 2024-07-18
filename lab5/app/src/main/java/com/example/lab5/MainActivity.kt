package com.example.lab5

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lab5.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding
    private lateinit var mainCanvas: MainCanvas
    private lateinit var myEditor: MyEditor
    private lateinit var table: Table

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        super.onCreate(savedInstanceState)



        mainCanvas = bindingClass.mainCanvas
        myEditor = mainCanvas.myEditor
        table = Table(this)
        myEditor.getTable(table)
        val fragmentTr: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTr.replace(R.id.fragment, table)
        fragmentTr.commit()
        bindingClass.button.setOnClickListener {

            bindingClass.fragment.isVisible = true
            bindingClass.button2.isVisible = true
        }
        bindingClass.button2.setOnClickListener {
            bindingClass.fragment.isVisible = false
            bindingClass.button2.isVisible = false

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2, menu)
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {

            R.id.line -> {
                supportActionBar?.title = R.string.line.toString()
                myEditor.currentShape = LineShape()
                return true
            }

            R.id.ellipse -> {
                supportActionBar?.title = R.string.ellipse.toString()
                myEditor.currentShape = EllipseShape()
                return true
            }

            R.id.rectangle -> {
                supportActionBar?.title = R.string.rect.toString()
                myEditor.currentShape = RectangleShape()
                return true
            }

            R.id.point -> {
                supportActionBar?.title = R.string.point.toString()
                myEditor.currentShape = PointShape()
                return true
            }

            R.id.cube -> {
                supportActionBar?.title = R.string.cube.toString()
                myEditor.currentShape = CubeShape()
            }

            R.id.line00 -> {
                supportActionBar?.title = R.string.line00.toString()
                myEditor.currentShape = Line00Shape()
            }

            R.id.save -> {
                onSave()
            }
        }
        return true

    }

    private fun onSave() {
        val shapes = myEditor.getShapes()
        var data = ""
             shapes.forEach {
                 data += it.name
                 data += " "
                 data += it.xStart.toString()
                 data += " "
                 data += it.yStart.toString()
                 data += " "
                 data += it.xEnd.toString()
                 data += " "
                 data += it.yEnd.toString()

            data += "\n"
        }

        createSaveDialog(data)
    }

    private fun createSaveDialog(data: String) {
        val file = File(this)
        val inputName = EditText(this)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Зберегти як ")
        builder.setView(inputName)
        builder.setNegativeButton("Відміна") { dialog, _ ->
            dialog.cancel()
        }
        builder.setPositiveButton("Так") { _, _ ->
            val fileName = inputName.text.toString()
            file.writeFile(fileName, data)
            Toast.makeText(this, "Saved to $fileName file", Toast.LENGTH_LONG).show()
        }
        builder.create().show()
    }


}