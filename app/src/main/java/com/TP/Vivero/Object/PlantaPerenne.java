package com.TP.Vivero.Object;

public class PlantaPerenne extends Planta {

    public PlantaPerenne(String id) {


        super(id);
    }

    public void siguiente(){

        CambioEstapaPerenne cambioEstapaPerenne = new CambioEstapaPerenne();

        cambioEstapaPerenne.siguiente();
    }
}
