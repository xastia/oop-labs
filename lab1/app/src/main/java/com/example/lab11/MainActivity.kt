package com.example.lab11



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab11.databinding.ActivityMainBinding
import kotlin.properties.Delegates.notNull


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private  var group by notNull<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root)}

        bindingClass.button.setOnClickListener{
            showWork11()
        }
         bindingClass.button2.setOnClickListener{
             showWork2()

        }
        group = savedInstanceState?.getString(KEY_GROUP) ?: " "

        setupWork11Listener()
        setupWork12Listener()
        setupWork2Listener()


    }


    private fun showWork11() {
        Work11.show(supportFragmentManager)
    }

    private fun setupWork11Listener() {
        Work11.setupListener(supportFragmentManager, this)
    }


    private fun setupWork12Listener() {
        Work12.setupListener(supportFragmentManager, this)
    }


    private fun showWork2() {
        Work2.show(supportFragmentManager, group)
    }

    private fun setupWork2Listener() {
        Work2.setupListener(supportFragmentManager, this) {
            this.group = it
            updateUi()
        }

    }


    private fun updateUi() {
        bindingClass.textView.text = "Ви обрали: $group "
    }


    companion object {
        private val KEY_GROUP = "group"
    }


}