package com.TP.Vivero.Object;

import java.util.ArrayList;

public class Planta {

    protected ArrayList<Etapa> etapas;
    protected int ubicacion;
    protected String nombre;
    protected int tempActual;
    protected int humedadActual;
    protected int luzActual;
    protected int hormona;
    protected int sustrato;
    protected String fecha_plantado;

    public Planta(){}


    public ArrayList<Etapa> getEtapas() {
        if(this.etapas==null) etapas = new ArrayList<>();
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

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha_plantado() {
        return fecha_plantado;
    }

    public void setFecha_plantado(String fecha_plantado) {
        this.fecha_plantado = fecha_plantado;
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

    public void siguiente(){}

    public Etapa getEtapaActual()
    {
        return etapas.get(0);
    }


}