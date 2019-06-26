package com.TP.Vivero.Model;

import android.app.Activity;

import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;

import java.util.ArrayList;
import java.util.HashMap;

public class Factory {

    private DatabaseHandler db;
    private ArrayList<String> arrayListName;

    public Factory(Activity activity) {

        db = new DatabaseHandler(activity);
        arrayListName = new ArrayList<>();
    }

    public void initName(){

        arrayListName.add("Rosa");
        arrayListName.add("Pino");
        arrayListName.add("Sauce");
        arrayListName.add("Girasol");
        arrayListName.add("Margarita");
    }

    public void init(){

        initName();

        int cont = 0;

        for(String item:arrayListName) setPlantaDb(item, cont++);
    }

    public void setPlantaDb(String nomb, int ubic) {

        Planta planta = new Planta();
        planta.setNombre(nomb);

        Etapa etapa = new Etapa();
        etapa.setNombre(nomb);
        etapa.setDuracion(5);
        etapa.setHumMax(2);
        etapa.setHumMin(1);
        etapa.setLuzMax(20);
        etapa.setLuzMin(5);
        etapa.setTempMax(25);
        etapa.setTempMin(10);
        etapa.setHormona(500);
        etapa.setSustrato(45);
        etapa.setEdad(0);

        Etapa etapa1 = new Etapa();
        etapa1.setNombre(nomb);
        etapa1.setDuracion(5);
        etapa1.setHumMax(2);
        etapa1.setHumMin(1);
        etapa1.setLuzMax(20);
        etapa1.setLuzMin(5);
        etapa1.setTempMax(25);
        etapa1.setTempMin(10);
        etapa1.setHormona(500);
        etapa1.setSustrato(45);
        etapa1.setEdad(1);

        Etapa etapa2 = new Etapa();
        etapa2.setNombre(nomb);
        etapa2.setDuracion(5);
        etapa2.setHumMax(2);
        etapa2.setHumMin(1);
        etapa2.setLuzMax(20);
        etapa2.setLuzMin(5);
        etapa2.setTempMax(25);
        etapa2.setTempMin(10);
        etapa2.setHormona(500);
        etapa2.setSustrato(45);
        etapa2.setEdad(2);

        Etapa etapa3 = new Etapa();
        etapa3.setNombre(nomb);
        etapa3.setDuracion(5);
        etapa3.setHumMax(2);
        etapa3.setHumMin(1);
        etapa3.setLuzMax(20);
        etapa3.setLuzMin(5);
        etapa3.setTempMax(25);
        etapa3.setTempMin(10);
        etapa3.setHormona(500);
        etapa3.setSustrato(45);
        etapa3.setEdad(3);

        db.savePlanta(planta);

        if(ubic%2==0){
            db.saveEtapa(etapa);
            db.saveEtapa(etapa2);
        }else{
            db.saveEtapa(etapa1);
            db.saveEtapa(etapa3);
        }

        setPlantadaBd(nomb, ubic);
    }

    public void setPlantadaBd(String nombre, int ubic){

        Planta planta = db.getPlantaByNomb(nombre);

        planta.setUbicacion(ubic);
        planta.setTempActual(15);
        planta.setHumedadActual(5);
        planta.setLuzActual(50);
        planta.setHormona(10);
        planta.setSustrato(46);

        db.savePlantadas(planta);
    }
}
