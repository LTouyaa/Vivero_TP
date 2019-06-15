package com.example.Vivero.Object;

import com.example.Vivero.Object.Etapa;

import java.util.ArrayList;

public abstract class Planta{

    private ArrayList<Etapa> etapas;
    private String id="";
    private int tempActual;
    private int humedadActual;
    private int luzActual;
    private int hormona;
    private int sustrato;



    public Planta(String id)
    {
        etapas = new ArrayList<Etapa>();
        this. id = id;
    }

    public void agregarEtapa(Etapa etapa)
    {
        etapas.add(etapa);
    }

    public String getID()
    {
        return id;
    }

    public void setTempActual(int tempActual){
        this.tempActual = tempActual;
    }

    public int getTempActual(){
        return tempActual;
    }

    public void setHumedadActual(int humedadActual){
        this.humedadActual = humedadActual;
    }

    public int getHumedadActual(){
        return humedadActual;
    }

    public void setLuzActual(int luzActual){
        this.luzActual = luzActual;
    }

    public int getLuzActual(){
        return luzActual;
    }

    public void setHormona(int hormona){
        this.hormona = hormona;
    }

    public int getHormona(){
        return hormona;
    }

    public void setSustrato(int sustrato){
        this.sustrato = sustrato;
    }

    public int getSustrato(){
        return sustrato;
    }

    public ArrayList<Etapa> listaEtapas(){
        return etapas;
    }

    public boolean tempCorrecta()
    {
        if ((tempActual>etapas.get(0).getTempMax())||(tempActual<etapas.get(0).getTempMin()))
        {
            return false;
        } else return true;
    }

    public boolean humCorrecta()
    {
        if ((humedadActual>etapas.get(0).getHumMax())||(humedadActual<etapas.get(0).getHumMin()))
        {
            return false;
        }else return true;
    }

    public boolean luzCorrecta()
    {
        if ((luzActual>etapas.get(0).getLuzMax())||(luzActual<etapas.get(0).getLuzMin()))
        {
            return false;
        }else return true;
    }

    public void actualizarParametros(int tempActual, int humedadActual, int luzActual){
        setHumedadActual(humedadActual);
        setTempActual(tempActual);
        setLuzActual(luzActual);
    }

    public abstract void actualizarEtapa();


}