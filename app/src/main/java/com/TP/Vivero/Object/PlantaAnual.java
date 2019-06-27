package com.TP.Vivero.Object;

public class PlantaAnual extends Planta {

    CambioEtapaAnual cambioEtapaAnual;

    public PlantaAnual() {
        super();
        cambioEtapaAnual = new CambioEtapaAnual();
    }

    public boolean siguiente(){

        return cambioEtapaAnual.siguiente(etapas);

    }
}
