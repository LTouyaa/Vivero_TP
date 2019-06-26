package com.TP.Vivero.Object;

import java.util.ArrayList;

class CambioEtapaPerenne implements Cambio{

    Etapa vegetativa;
    Etapa reproduccion;


    @Override
    public void siguiente(ArrayList<Etapa> etapas) {

        if(etapas.get(0).unPaso()){
            etapas.remove(0);
            if(etapas.size()==2){
                vegetativa = etapas.get(0);
                reproduccion = etapas.get(1);
            }
            if(etapas.isEmpty()){
                etapas.add(vegetativa);
                etapas.get(0).setProgreso_duracion(0);
                etapas.add(reproduccion);
                etapas.get(1).setProgreso_duracion(0);
            }
        }

    }
}
