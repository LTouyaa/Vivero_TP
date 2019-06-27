package com.TP.Vivero.Model;

import android.app.Activity;

import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;

import java.util.ArrayList;
import java.util.HashMap;

public class Factory {

    private DatabaseHandler db;


    public Factory(Activity activity) {

        db = new DatabaseHandler(activity);
    }




    public void init(){


        //Creacion de variables auxiliares
        String nomb;
        Planta planta = new Planta();
        Etapa etapa1 = new Etapa();
        Etapa etapa2 = new Etapa();
        Etapa etapa3 = new Etapa();
        Etapa etapa4 = new Etapa();
        Etapa etapa5 = new Etapa();

        //===========================================================
        //Cargado planta Soja

        nomb = "Soja";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);

        //===========================================================
        //Cargado planta Maiz

        nomb = "Maiz";
        planta.setNombre(nomb);
        db.savePlanta(planta);

        etapa1.setNombre(nomb);
        etapa1.setDuracion(2);
        etapa1.setHumMax(2);
        etapa1.setHumMin(1);
        etapa1.setLuzMax(20);
        etapa1.setLuzMin(5);
        etapa1.setTempMax(25);
        etapa1.setTempMin(10);
        etapa1.setHormona(500);
        etapa1.setSustrato(45);
        etapa1.setNumetapa(1);

        etapa2.setNombre(nomb);
        etapa2.setDuracion(2);
        etapa2.setHumMax(2);
        etapa2.setHumMin(1);
        etapa2.setLuzMax(20);
        etapa2.setLuzMin(5);
        etapa2.setTempMax(25);
        etapa2.setTempMin(10);
        etapa2.setHormona(500);
        etapa2.setSustrato(45);
        etapa2.setNumetapa(2);

        etapa3.setNombre(nomb);
        etapa3.setDuracion(2);
        etapa3.setHumMax(2);
        etapa3.setHumMin(1);
        etapa3.setLuzMax(20);
        etapa3.setLuzMin(5);
        etapa3.setTempMax(25);
        etapa3.setTempMin(10);
        etapa3.setHormona(500);
        etapa3.setSustrato(45);
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(2);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(2);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);

        //===========================================================
        //Cargado planta Alfa

        nomb = "Alfa";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Mani

        nomb = "Mani";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Zanahoria

        nomb = "Zanahoria";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Perejil

        nomb = "Perejil";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);

        //===========================================================
        //Cargado planta Cebolla

        nomb = "Cebolla";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Remolacha

        nomb = "Remolacha";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Pino

        nomb = "Pino";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Rosa

        nomb = "Rosa";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Jazmin

        nomb = "Jazmin";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);


        //===========================================================
        //Cargado planta Limon

        nomb = "Limon";
        planta.setNombre(nomb);
        db.savePlanta(planta);

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
        etapa1.setNumetapa(1);

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
        etapa2.setNumetapa(2);

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
        etapa3.setNumetapa(3);

        etapa4.setNombre(nomb);
        etapa4.setDuracion(5);
        etapa4.setHumMax(2);
        etapa4.setHumMin(1);
        etapa4.setLuzMax(20);
        etapa4.setLuzMin(5);
        etapa4.setTempMax(25);
        etapa4.setTempMin(10);
        etapa4.setHormona(500);
        etapa4.setSustrato(45);
        etapa4.setNumetapa(4);

        etapa5.setNombre(nomb);
        etapa5.setDuracion(5);
        etapa5.setHumMax(2);
        etapa5.setHumMin(1);
        etapa5.setLuzMax(20);
        etapa5.setLuzMin(5);
        etapa5.setTempMax(25);
        etapa5.setTempMin(10);
        etapa5.setHormona(500);
        etapa5.setSustrato(45);
        etapa5.setNumetapa(5);

        db.saveEtapa(etapa1);
        db.saveEtapa(etapa2);
        db.saveEtapa(etapa3);
        db.saveEtapa(etapa4);
        db.saveEtapa(etapa5);



    }



}
