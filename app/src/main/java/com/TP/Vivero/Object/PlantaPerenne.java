package com.TP.Vivero.Object;

import android.support.annotation.NonNull;

public class PlantaPerenne extends Planta {

    CambioEtapaPerenne cambioEtapaPerenne;

    public PlantaPerenne() {
        super();
        cambioEtapaPerenne = new CambioEtapaPerenne();
    }

    public boolean siguiente(){
        return cambioEtapaPerenne.siguiente(this.etapas);
    }

    @NonNull
    @Override
    public String toString() {
        return "Perenne";
    }
}
