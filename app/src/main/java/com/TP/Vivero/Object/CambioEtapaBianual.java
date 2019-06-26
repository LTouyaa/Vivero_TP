package com.TP.Vivero.Object;

import java.util.ArrayList;

class CambioEtapaBianual implements Cambio{

    boolean flag;
    Etapa vegetativa;
    Etapa reproduccion;

    public CambioEtapaBianual(){
        flag = false;
    }

    @Override
    public void siguiente(ArrayList<Etapa> etapas) {

        if(etapas.get(0).unPaso()){
            etapas.remove(0);
            if(etapas.size()==2){
                vegetativa = etapas.get(0);
                reproduccion = etapas.get(1);
            }
            if(etapas.isEmpty()){
                if(flag==false){
                    etapas.add(vegetativa);
                    etapas.get(0).setProgreso_duracion(0);
                    etapas.add(reproduccion);
                    etapas.get(1).setProgreso_duracion(0);
                }else{
                    //Accion fin de vida de la planta
                }
            }
        }

    }
}
