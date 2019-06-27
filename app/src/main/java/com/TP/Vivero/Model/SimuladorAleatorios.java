package com.TP.Vivero.Model;

import java.util.Random;

public class SimuladorAleatorios {

    Random random;

    public SimuladorAleatorios()
    {
        random= new Random();
    }



    public int  getTempSimulada()
  {
      int temp;

      temp = random.nextInt(60)-10;

      return temp;
  }

  public int getPorcentajeSimulado()
  {
      int hum =random.nextInt(100);
        return hum;
  }

    public int getLuzSimulado()
    {
        int luz =random.nextInt(500);
        return luz;
    }



}
