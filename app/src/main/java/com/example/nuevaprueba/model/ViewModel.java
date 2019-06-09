package com.example.nuevaprueba.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class ViewModel extends android.arch.lifecycle.ViewModel {

    private MutableLiveData<String> nombPlantas = new MutableLiveData<>();



    public LiveData<String> getNombPlantas() {

        return nombPlantas;
    }

    public void setNombPlantas(String nombre){

        nombPlantas.setValue(nombre);
    }

}
