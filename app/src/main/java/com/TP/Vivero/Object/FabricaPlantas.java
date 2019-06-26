package com.TP.Vivero.Object;

import android.widget.Switch;

public class FabricaPlantas {

    public FabricaPlantas(){}

    public Planta crearPlanta(String nombre){

        Planta P;

        switch (nombre){
            //Plantas Anuales
            case "Soja":
            case "Maiz":
            case "Alfa":
            case "Mani":
                P = new PlantaAnual();
                break;
            //Plantas Bianuales
            case "Zanahoria":
            case "Perejil":
            case "Cebolla":
            case "Remolacha":
                P = new PlantaBianual();
                break;
            //Plantas Perennes
            case "Pino":
            case "Rosa":
            case "Jazmin":
            case "Limon":
                P = new PlantaPerenne();
                break;
            default:
                P = new Planta();
                break;
        }

        return P;


    }
}
