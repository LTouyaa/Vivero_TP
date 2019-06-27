package com.TP.Vivero.Model;
import com.TP.Vivero.Controller.Controller;
import java.util.Observable;

public class PasoTiempoModel extends Observable {

    private Controller controller;

    public PasoTiempoModel(Controller controller){this.controller = controller;}

    public void pasar(){ notifyObservers(null);}

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
        controller.update(this, arg);
    }
}