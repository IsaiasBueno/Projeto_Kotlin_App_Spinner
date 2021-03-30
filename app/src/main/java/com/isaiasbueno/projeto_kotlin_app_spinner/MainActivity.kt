package com.isaiasbueno.projeto_kotlin_app_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var menu: Spinner
    lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.textView)
        menu = findViewById(R.id.spinner)
        botao = findViewById(R.id.button)

        var estados = arrayOf("Acre","Alagoas","Amazonas","Amapá","Bahia","Ceará","Distrito Federal",
            "Espírito Santo", "Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais",
            "Pará","Paraíba", "Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte",
            "Rio Grande do Sul", "Rondônia","Roraima", "Santa Catarina","São Paulo", "Sergipe",
            "Tocantins")
        menu.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, estados)

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                texto.text = estados[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        botao.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext,estados[menu.selectedItemPosition],
                    Toast.LENGTH_LONG).show()
            }

        })
    }
}