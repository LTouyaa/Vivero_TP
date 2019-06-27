package com.TP.Vivero.Object;

import java.util.ArrayList;

class CambioEtapaAnual implements Cambio {

    boolean flagremover;

    public CambioEtapaAnual(){
        flagremover = false;
    }

    @Override
    public boolean siguiente(ArrayList<Etapa> etapas) {

        if(etapas.get(0).unPaso()){
            etapas.remove(0);
            if(etapas.isEmpty()){
                flagremover = true;
                //Accion fin de Vida de la planta
            }
        }
        return flagremover;
    }
}
