package com.example.estadosactivity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_actividad)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("CICLO_VIDA","Se ejecuta el método onCreate 2ª actividad")
        findViewById<Button>(R.id.button_segundaactividad).setOnClickListener { finish() }
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO_VIDA","Se ejecuta el método onStart 2ª actividad")

    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO_VIDA","Se ejecuta el método onRsume, la actividad se pone a correr 2ª actividad")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLO_VIDA","Se ejecuta el método onPause 2ª actividad")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO_VIDA","Se ejecuta el método onStop, la activity no es visible 2ª actividad")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO_VIDA","Se ejecuta el método onDestroy, la actividad muere 2ª actividad")
    }
}