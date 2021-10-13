package com.capi.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTitle("HipoCalc")
        var btnCalcular = findViewById(R.id.btnCalcular) as Button
        var btnLimpiar = findViewById(R.id.btnLimpiar) as Button
        var inputLadoA = findViewById(R.id.tbLadoA) as EditText
        var inputLadoB = findViewById(R.id.tbLadoB) as EditText
        var outputResultado = findViewById(R.id.tbResultado) as EditText

        outputResultado.isFocusable = false;
        var resultado: Double
        btnCalcular.setOnClickListener {
            if(!validarCampos(inputLadoA.text.toString(), inputLadoB.text.toString())){
                val mensaje = "Campos faltantes!"
                val duration = Toast.LENGTH_LONG
                val toast = Toast.makeText(applicationContext,mensaje,duration)
                toast.show()
            }else{
                resultado = calcularHipotenusa(inputLadoA.text.toString(), inputLadoB.text.toString())
                outputResultado.setText(resultado.toString())
            }
        }

        btnLimpiar.setOnClickListener{
            inputLadoA.setText("")
            inputLadoB.setText("")
            outputResultado.setText("")
        }
    }

    fun validarCampos(inputA: String, inputB: String): Boolean{
        if(inputA.equals("") || inputB.equals("")){
            return false
        }
        return true
    }
    fun calcularHipotenusa(inputA: String, inputB: String): Double {
        var ladoA = inputA.toDouble()
        var ladoB = inputB.toDouble()
        var resultado = (elevarNumero(ladoA)+elevarNumero(ladoB))
        resultado = sqrt(resultado)
        return resultado
    }

    fun elevarNumero(numeroElevar: Double): Double{
        var resultado:Double = 1.0
        for(i in 1..2)
            resultado *= numeroElevar
        return resultado
    }
}