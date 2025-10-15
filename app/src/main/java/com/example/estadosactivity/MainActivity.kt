package com.example.estadosactivity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
val miviewmodel: MiviewModel by viewModels()
    lateinit var etiqueta: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etiqueta=findViewById<TextView>(R.id.textView)

        Log.i("CICLO_VIDA","Se ejecuta el método onCreate, se crea la Actividad")

        findViewById<Button>(R.id.button_abrir3actividad).setOnClickListener {
            var intent= Intent(this, TerceraActividad::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.button_dialogo).setOnClickListener {
        /*   var dialogoBuilder= AlertDialog.Builder(this)
            dialogoBuilder.apply {
                title="DIALOGO DE PRUEBA"
                setMessage("ESTO ES UN DIALOGO DE PRUEBA")
            }
            dialogoBuilder.create().show()*/
            MiDialogoFragment().show(supportFragmentManager,"DIALOGO")
        }
        findViewById<Button>(R.id.button_abrir2actividad).setOnClickListener {
            var intent= Intent(this, SegundaActividad::class.java)
            startActivity(intent)
        }
        etiqueta.text= miviewmodel.dato.toString()
        findViewById<Button>(R.id.button_menos).setOnClickListener {

            miviewmodel.dato--
            etiqueta.text=miviewmodel.dato.toString()

        }
        findViewById<Button>(R.id.button_mas).setOnClickListener {
          miviewmodel.dato++
            etiqueta.text=miviewmodel.dato.toString()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.i("CICLO_VIDA","Se ejecuta el método onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO_VIDA","Se ejecuta el método onRsume, la actividad se pone a correr")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLO_VIDA","Se ejecuta el método onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO_VIDA","Se ejecuta el método onStop, la activity no es visible")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO_VIDA","Se ejecuta el método onDestroy, la actividad muere")
    }
}

class MiDialogoFragment: DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Start game")
                .setPositiveButton("Start") { dialog, id ->
                    // START THE GAME!
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    // User cancelled the dialog.
                    dialog.dismiss()
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}