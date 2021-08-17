package sg.edu.rp.c347.id19023980.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
var equation = ""
var answer = 0.0
var equationString = ""
var choice = ""
var negative = false
var dot = false
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEquals.setOnClickListener {
            dot = false
            if (choice == "plus"){
                if (equation != ""){
                    val num = equation.toDouble()
                    if (answer ==0.0) {
                        answer = num
                        equation = ""
                    }else{
                        answer += num
                        equation = ""
                    }
                }
            }else if (choice == "minus"){
                if (equation != ""){
                    val num = equation.toDouble()
                    if (answer ==0.0) {
                        answer = num
                        equation = ""
                    }else{
                        answer -= num
                        equation = ""
                    }
                }
            }else if (choice == "multiply"){
                if (equation != ""){
                    val num = equation.toDouble()
                    if (answer ==0.0) {
                        answer = num
                        equation = ""
                    }else{
                        answer *= num
                        equation = ""
                    }
                }
            }else if (choice == "divide"){
                if (equation != "") {
                    val num = equation.toDouble()
                    if (num != 0.0) {
                        if (answer == 0.0) {
                            answer = num
                            equation = ""
                        } else {
                            answer /= num
                            equation = ""
                        }
                    } else {
                        Toast.makeText(
                            this,
                            "You can't divide a number by zero",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }else if (choice == "modulus"){
                if (equation != ""){
                    val num = equation.toDouble()
                    if (answer ==0.0) {
                        answer = num
                        equation = ""
                    }else{
                        answer /= 100
                        equation = ""
                    }
                }
            }
            tvAnswer.text = answer.toString()
        }
        btnDivide.setOnClickListener {
            choice = "divide"
            equationString = "/"
            if (equation != ""){
                val num = equation.toDouble()
                if (num != 0.0){
                    if (answer ==0.0) {
                        answer = num
                        equation = ""
                    }else{
                        answer /= num
                        equation = ""
                    }
                }else{
                    Toast.makeText(this,"You can't divide a number by zero",Toast.LENGTH_SHORT).show()

                }

            }
            tvEquation.text = equationString
        }
        btnMultiply.setOnClickListener {
            choice = "multiply"
            equationString = "*"
            if (equation != ""){
                val num = equation.toDouble()
                if (answer ==0.0) {
                    answer = num
                    equation = ""
                }else{
                    answer *= num
                    equation = ""
                }
            }
            tvEquation.text = equationString
        }
        btnMinus.setOnClickListener {
            choice = "minus"
            equationString = "-"
            if (equation != ""){
                val num = equation.toDouble()
                if (answer ==0.0) {
                    answer = num
                    equation = ""
                }else{
                    answer -= num
                    equation = ""
                }
            }
            tvEquation.text = equationString
        }
        btnPlus.setOnClickListener {
            choice = "plus"
            equationString = "+"
            if (equation != ""){
                val num = equation.toDouble()
                if (answer ==0.0) {
                    answer = num
                    equation = ""
                }else{
                    answer += num
                    equation = ""
                }
            }
            tvEquation.text = equationString
        }
        btnAC.setOnClickListener {
            answer = 0.0
            equation = ""
            equationString = ""
            tvAnswer.text = ""
            tvEquation.text = ""
            negative = false
        }
        btnModulus.setOnClickListener {
            choice = "modulus"
            equationString = "$equation %"
            if (equation != ""){
                val num = equation.toDouble()
                if (answer ==0.0) {
                    answer = num / 100
                    equation = ""
                }else{
                    answer /= 100
                    equation = ""
                }
            }
            tvEquation.text = equationString
            tvAnswer.text = answer.toString()
        }
        btnNegativePositive.setOnClickListener {
            if (!negative){
                equation = "-$equation"
                tvEquation.text = equation
                negative = true
            }else{
                var split = equation.split("-")
                tvEquation.text = split[0]
                equation = split[0]
                negative = false
            }

        }
        btnDot.setOnClickListener {
            if (dot == false){
                equation += "."
                tvEquation.text = equation
                dot = true
            }else{
                Toast.makeText(this,"dot has already been used",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun onBtnClick(view: View){

        val btnSelected = view as Button
        when (btnSelected.id) {
            btn0.id -> equation += "0"
            btn1.id -> equation += "1"
            btn2.id -> equation += "2"
            btn3.id -> equation += "3"
            btn4.id -> equation += "4"
            btn5.id -> equation += "5"
            btn6.id -> equation += "6"
            btn7.id -> equation += "7"
            btn8.id -> equation += "8"
            btn9.id -> equation += "9"
            btnAC.id -> equation = "0"
            btnDot.id -> equation += "."
        }
        tvEquation.text = equation
    }
}