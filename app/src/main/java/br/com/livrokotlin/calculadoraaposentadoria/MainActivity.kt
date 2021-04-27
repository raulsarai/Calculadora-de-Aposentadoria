package br.com.livrokotlin.calculadoraaposentadoria

import androidx.appcompat.app.AppCompatActivity
import	android.os.Bundle
import	android.widget.Button
import	android.widget.EditText
import	android.widget.Spinner
import	android.widget.TextView
import	android.widget.ArrayAdapter
import  kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //definindo	o	arquivo	de	layout
        setContentView(R.layout.activity_main)

        //acessando	o	spinner
        val	spn_sexo	=	findViewById<Spinner>(R.id.spn_sexo)

        //acessando	a	caixa	de	idade
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        //acessando	o	botão	de	calcular
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //acessando	o	texto	de	resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("MASCULINO", "FEMININO"))


        btn_calcular.setOnClickListener	{
            //capturando	o	sexo	selecionado
            val	sexo	=	spn_sexo.selectedItem	as	String
            //variável	para	guardar	o	resultado	do	cálculo
            var	resultado	=	0
            //verificando campo vazio
            val verificaIdadeVazia = txt_idade.text.toString()
            if ( verificaIdadeVazia.isNullOrEmpty()) {
                txt_idade.error = "Insira a idade para realizar o cálculo"
            }


            //capturando	a	idade	digitada
            val	idade	=	txt_idade.text.toString().toInt()
                //verificando	o	sexo	da	pessoa
                if (sexo == "MASCULINO") {
                    resultado = 65 - idade
                } else {
                    resultado = 60 - idade
                }
                //Atualizando	a	tela	de	acordo	com	o	resultado	do	cálculo
                txt_resultado.text = "Faltam $resultado anos para você se aposentar."
            }
        }

    }