package com.TP.Vivero.Object;

public class Etapa {
    private String nombre;
    private int numetapa;
    private int duracion;
    private int progreso_duracion;
    private int tempMax;
    private int tempMin;
    private int humMax;
    private int humMin;
    private int luzMax;
    private int luzMin;
    private int hormona;
    private int sustrato;

    public Etapa(){}

    public Etapa(String nombre, int numetapa, int duracion, int tempMax, int tempMin, int humMax, int humMin, int hormona, int luzMax, int luzMin, int sustrato) {

        this.nombre = nombre;
        this.numetapa = numetapa;
        this.duracion = duracion;
        this.humMax = humMax;
        this.humMin = humMin;
        this.luzMax = luzMax;
        this.luzMin = luzMin;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.hormona = hormona;
        this.sustrato = sustrato;
        progreso_duracion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumetapa(){
        return numetapa;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getProgreso_duracion(){
        return progreso_duracion;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getHumMax() {
        return humMax;
    }

    public int getHumMin() {
        return humMin;
    }

    public int getTempMin() {
        return tempMin;
    }

    public int getLuzMax() {
        return luzMax;
    }

    public int getLuzMin() {
        return luzMin;
    }

    public int getHormona() {
        return hormona;
    }

    public int getSustrato() {
        return sustrato;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumetapa(int numetapa){
        this.numetapa = numetapa;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setProgreso_duracion(int progreso_duracion){
        this.progreso_duracion = progreso_duracion;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public void setHumMax(int humMax) {
        this.humMax = humMax;
    }

    public void setHumMin(int humMin) {
        this.humMin = humMin;
    }

    public void setLuzMax(int luzMax) {
        this.luzMax = luzMax;
    }

    public void setLuzMin(int luzMin) {
        this.luzMin = luzMin;
    }

    public void setHormona(int hormona) {
        this.hormona = hormona;
    }

    public void setSustrato(int sustrato) {
        this.sustrato = sustrato;
    }



    //Revisar si les parece adecuada la implementacion.

    public boolean unPaso() {
        if (progreso_duracion < duracion) {
            progreso_duracion += 1;
            return false;
        } else {
            return true;
        }
    }

}
