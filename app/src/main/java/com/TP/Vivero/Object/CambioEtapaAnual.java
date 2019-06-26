package com.TP.Vivero.Object;

import java.util.ArrayList;

class CambioEtapaAnual implements Cambio {
    @Override
    public void siguiente(ArrayList<Etapa> etapas) {

        if(etapas.get(0).unPaso()){
            etapas.remove(0);
            if(etapas.isEmpty()){
                //Accion fin de Vida de la planta
            }
        }

    }
}
