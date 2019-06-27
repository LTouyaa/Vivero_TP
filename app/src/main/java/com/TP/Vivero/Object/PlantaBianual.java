package com.TP.Vivero.Object;

public class PlantaBianual extends Planta{

    CambioEtapaBianual cambioEtapaBianual;

    public PlantaBianual() {
        super();
        cambioEtapaBianual = new CambioEtapaBianual();
    }

    public boolean siguiente(){
        return cambioEtapaBianual.siguiente(etapas);
    }
}
