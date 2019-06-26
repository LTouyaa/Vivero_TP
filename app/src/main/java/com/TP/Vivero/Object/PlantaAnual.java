package com.TP.Vivero.Object;

public class PlantaAnual extends Planta {

    CambioEtapaAnual cambioEtapaAnual;

    public PlantaAnual() {
        super();
        cambioEtapaAnual = new CambioEtapaAnual();
    }

    public void siguiente(){

        cambioEtapaAnual.siguiente(etapas);

    }
}
