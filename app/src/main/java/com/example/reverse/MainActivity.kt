package com.example.reverse

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val revButton = findViewById<Button>(R.id.button)
        val mainHandler = Handler(Looper.getMainLooper())
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val textView = findViewById<TextView>(R.id.textView)

        revButton.setOnClickListener {
            var str = editText.text.toString()
            var revstr = str.reversed()
            editText.setText(revstr)
        }
        var i = 0
        var j = 0
        var z = 0
        var s = ""
        mainHandler.post(object : Runnable {
            override fun run() {

                s += getFibonacciByIndex(i).toString()+" "
                textView.text = s
                RGBtext(j)
                i++


                if(j%5==0)
                {
                    j=0

                }
                j++
                mainHandler.postDelayed(this, 1000)


            }
        })

    }
    fun getFibonacciByIndex(index: Int): Long {
        if (index == 0) {
            return 0 // первый элемент последовательности
        }
        if (index < 0 || index > 92) {
            // при индексе 93 происходит переполнение типа long
            throw IndexOutOfBoundsException()
        }
        var n0 = 0L
        var n1 = 1L
        for (i in 2..index) {
            val n2 = n0 + n1
            n0 = n1
            n1 = n2
        }
        return n1
    }

    fun RGBtext(incol:Int){
        val textViewRed = findViewById<TextView>(R.id.textView2)
        val textViewYellow = findViewById<TextView>(R.id.textView3)
        val textViewGreen = findViewById<TextView>(R.id.textView4)
        if (incol==1){
            textViewRed.setTextColor(Color.RED)
            textViewGreen.setTextColor(Color.BLACK)
            textViewYellow.setTextColor(Color.BLACK)
        }
        if (incol==2){
            textViewYellow.setTextColor(Color.YELLOW)
            textViewRed.setTextColor(Color.BLACK)
            textViewGreen.setTextColor(Color.BLACK)
        }
        if (incol==3){
            textViewGreen.setTextColor(Color.GREEN)
            textViewYellow.setTextColor(Color.BLACK)
            textViewRed.setTextColor(Color.BLACK)
        }
        if (incol==4){
            textViewGreen.setTextColor(Color.BLACK)
            textViewYellow.setTextColor(Color.YELLOW)
            textViewRed.setTextColor(Color.BLACK)
        }
        if (incol==5){
            textViewGreen.setTextColor(Color.BLACK)
            textViewYellow.setTextColor(Color.BLACK)
            textViewRed.setTextColor(Color.RED)
        }


    }

}