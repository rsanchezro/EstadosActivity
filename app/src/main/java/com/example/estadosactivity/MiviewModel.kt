package com.example.estadosactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MiviewModel: ViewModel() {

  private val _dato= MutableLiveData(0)
  val dato: LiveData<Int> = _dato
    public fun incrementar(){
        _dato.value=(_dato.value?:0)+1
    }
    public fun decrementar(){
        _dato.value=(_dato.value?:0)-1
    }

}