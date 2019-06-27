package com.TP.Vivero.Object;

public class PlantaPerenne extends Planta {

    CambioEtapaPerenne cambioEtapaPerenne;

    public PlantaPerenne() {
        super();
        cambioEtapaPerenne = new CambioEtapaPerenne();
    }

    public boolean siguiente(){
        return cambioEtapaPerenne.siguiente(this.etapas);
    }
}
