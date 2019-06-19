package com.TP.Vivero.Object;

public class PlantaBianual extends Planta{

    public PlantaBianual(String id) {
        super(id);
    }

    public void siguiente(){

        CambioEtapaBianual cambioEtapaBianual = new CambioEtapaBianual();

        cambioEtapaBianual.siguiente();
    }
}
