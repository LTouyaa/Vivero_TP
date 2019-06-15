package com.TP.Vivero.Object;

public class PlantaAnual extends Planta {

    public PlantaAnual(String id) {
        super(id);
    }

    public void siguiente(){

        CambioEstapaAnual cambioEstapaAnual = new CambioEstapaAnual();

        cambioEstapaAnual.siguiente();

    }
}
