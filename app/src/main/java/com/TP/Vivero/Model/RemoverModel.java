package com.TP.Vivero.Model;

import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Object.Planta;

import java.util.Observable;

public class RemoverModel extends Observable {

    private Controller controller;

    public RemoverModel(Controller controller){this.controller = controller;}

    public void removerPlanta(Planta planta){ notifyObservers(planta);}

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
        controller.update(this, arg);
    }
}
