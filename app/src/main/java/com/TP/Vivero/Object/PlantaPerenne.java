package com.TP.Vivero.Object;

public class PlantaPerenne extends Planta {

    CambioEtapaPerenne cambioEtapaPerenne;

    public PlantaPerenne() {
        super();
        cambioEtapaPerenne = new CambioEtapaPerenne();
    }

    public void siguiente(){
        cambioEtapaPerenne.siguiente(etapas);
    }
}
