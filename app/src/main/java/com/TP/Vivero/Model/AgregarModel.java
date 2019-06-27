package com.TP.Vivero.Model;

import android.content.Context;

import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.Vista.Fragment.PlantadasFragment;

import java.util.Observable;

public class AgregarModel extends Observable {

    private Controller controller;

    public AgregarModel(Controller controller){
        this.controller = controller;
    }

    public void agregarPlanta(Planta planta){
        notifyObservers(planta);
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
        controller.update(this, arg);
    }
}
