package com.TP.Vivero.Object;

import java.util.ArrayList;

public class Planta {

    private ArrayList<Etapa> etapas;
    private int ubicacion;
    private String nombre;
    private int tempActual;
    private int humedadActual;
    private int luzActual;
    private int hormona;
    private int sustrato;

    public Planta(){}


    public ArrayList<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(ArrayList<Etapa> etapas) {
        if(etapas==null) this.etapas = new ArrayList<>();
        this.etapas = etapas;
    }

    public void agregarEtapa(Etapa etapa){
        if(this.etapas == null) this.etapas = new ArrayList<>();
        etapas.add(etapa);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTempActual() {
        return tempActual;
    }

    public void setTempActual(int tempActual) {
        this.tempActual = tempActual;
    }

    public int getHumedadActual() {
        return humedadActual;
    }

    public void setHumedadActual(int humedadActual) {
        this.humedadActual = humedadActual;
    }

    public int getLuzActual() {
        return luzActual;
    }

    public void setLuzActual(int luzActual) {
        this.luzActual = luzActual;
    }

    public int getHormona() {
        return hormona;
    }

    public void setHormona(int hormona) {
        this.hormona = hormona;
    }

    public int getSustrato() {
        return sustrato;
    }

    public void setSustrato(int sustrato) {
        this.sustrato = sustrato;
    }

    public boolean tempCorrecta() {
        if ((tempActual > etapas.get(0).getTempMax()) || (tempActual < etapas.get(0).getTempMin())) {
            return false;
        } else return true;
    }

    public boolean humCorrecta() {
        if ((humedadActual > etapas.get(0).getHumMax()) || (humedadActual < etapas.get(0).getHumMin())) {
            return false;
        } else return true;
    }

    public boolean luzCorrecta() {
        if ((luzActual > etapas.get(0).getLuzMax()) || (luzActual < etapas.get(0).getLuzMin())) {
            return false;
        } else return true;
    }

    public void actualizarParametros(int tempActual, int humedadActual, int luzActual) {
        setHumedadActual(humedadActual);
        setTempActual(tempActual);
        setLuzActual(luzActual);
    }

    public boolean unPaso(){

        if(etapas.isEmpty()) return false;

        if (etapas.get(0).getEdad() < etapas.get(0).getDuracion()) {
            etapas.remove(0);
            return false;
        } else {
            return true;
        }
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Etapa getEtapaActual()
    {
        return etapas.get(0);
    }
}