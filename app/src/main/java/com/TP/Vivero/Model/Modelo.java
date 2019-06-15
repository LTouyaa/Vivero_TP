package com.TP.Vivero.Model;

import com.TP.Vivero.Object.Planta;

import java.util.Collection;
import java.util.HashMap;

public class Modelo {

    private HashMap<Integer, Planta> vivero;


    public Modelo() {
        vivero = new HashMap<Integer, Planta>();
    }

    public void agregarPlanta(Integer lugar, Planta p) {
        if (vivero.containsKey(lugar)) {
            // Toast.makeText(this, "Lugar ocupado", Toast.LENGTH_SHORT).show();
        } else {
            vivero.put(lugar, p);
        }
    }

    public void removerPlanta(Integer lugar) {
        if (vivero.containsKey(lugar)) {
            vivero.remove(lugar);
        } else {
            // Toast.makeText(this, "El lugar estaba vacio", Toast.LENGTH_SHORT).show();
        }
    }

    public Planta getPlanta(Integer lugar) {
        if (vivero.containsKey(lugar)) {
            return vivero.get(lugar);
        } else {
            // Toast.makeText(this, "El lugar esta vacio", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public Collection<Planta> obtenerColeccion() {
        return vivero.values();
    }

    public void avanzar() {
        Collection<Planta> C = obtenerColeccion();
        for (Planta P : C) {
        }
    }
}
