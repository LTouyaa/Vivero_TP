package com.TP.Vivero.Model;


import com.TP.Vivero.Object.FabricaPlantas;
import com.TP.Vivero.Object.Planta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Modelo {

    private ArrayList<Planta> plantadas;


    public Modelo() {
        plantadas = new ArrayList<>();
    }

    public void agregarPlanta(Planta planta) {
        plantadas.add(planta);

    }

    public void agregarPlanta(ArrayList<Planta> arrayList){
        plantadas.clear();
        plantadas.addAll(arrayList);
    }

    public void removerPlanta(int ubicacion) {

        for(Planta planta: plantadas )
        {
            if(planta.getUbicacion() == ubicacion);
            {plantadas.remove(planta);
            return ;}
        }
    }

    public ArrayList<Planta> getAllPlantadas()
    {
        FabricaPlantas fabricaPlantas = new FabricaPlantas();

        ArrayList<Planta> arrayList= new ArrayList<>();

        for(Planta item : plantadas){

            Planta planta = fabricaPlantas.crearPlanta(item.getNombre());
            planta.setNombre(item.getNombre());
            planta.setUbicacion(item.getUbicacion());
            planta.setEtapas(item.getEtapas());
            planta.setHumedadActual(item.getHumedadActual());
            planta.setTempActual(item.getTempActual());
            planta.setLuzActual(item.getLuzActual());
            planta.setHormona(item.getHormona());
            planta.setSustrato(item.getSustrato());

            arrayList.add(planta);
        }

        return arrayList;
    }

    public Boolean existPlantada (int ubicacion)
    {
        for (Planta planta: plantadas)
        {
            if( planta.getUbicacion()== ubicacion)
            {
                return true;
            }
        }
        return false;
    }

    public Planta getPlantada (int ubicacion)
    {
        for (Planta planta: plantadas)
        {
            if( planta.getUbicacion()== ubicacion)
            {
                return planta;
            }
        }

        return null;

    }

    public void clearPlantadas()
    {
        plantadas.clear();
    }
}
