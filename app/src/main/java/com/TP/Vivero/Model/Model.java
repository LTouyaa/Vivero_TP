package com.TP.Vivero.Model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.TP.Vivero.Object.Planta;

public class Model extends ViewModel {

    private final MutableLiveData<Planta> planta = new MutableLiveData<>();

    public void planta(Planta planta, Context context){
        planta.setPlanta(planta, context);
    }

    public LiveData<Planta> getPlant(){
        return planta;
    }
}
