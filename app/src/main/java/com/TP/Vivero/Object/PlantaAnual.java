package com.TP.Vivero.Object;

import android.support.annotation.NonNull;

public class PlantaAnual extends Planta {

    CambioEtapaAnual cambioEtapaAnual;

    public PlantaAnual() {
        super();
        cambioEtapaAnual = new CambioEtapaAnual();
    }

    public boolean siguiente(){

        return cambioEtapaAnual.siguiente(etapas);

    }

    @NonNull
    @Override
    public String toString() {
        return "Anual";
    }
}
