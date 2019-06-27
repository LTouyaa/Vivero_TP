package com.TP.Vivero.Object;

import android.support.annotation.NonNull;

public class PlantaBianual extends Planta{

    CambioEtapaBianual cambioEtapaBianual;

    public PlantaBianual() {
        super();
        cambioEtapaBianual = new CambioEtapaBianual();
    }

    public boolean siguiente(){
        return cambioEtapaBianual.siguiente(etapas);
    }

    @NonNull
    @Override
    public String toString() {
        return "Bianual";
    }
}
