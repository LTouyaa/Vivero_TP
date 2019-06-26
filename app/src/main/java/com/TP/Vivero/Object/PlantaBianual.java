package com.TP.Vivero.Object;

public class PlantaBianual extends Planta{

    CambioEtapaBianual cambioEtapaBianual;

    public PlantaBianual() {
        super();
        cambioEtapaBianual = new CambioEtapaBianual();
    }

    public void siguiente(){
        cambioEtapaBianual.siguiente(etapas);
    }
}
