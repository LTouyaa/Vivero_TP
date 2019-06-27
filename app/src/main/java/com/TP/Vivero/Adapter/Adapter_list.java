package com.TP.Vivero.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_list extends ArrayAdapter<Planta> {

    Context context;
    int layout_list;
    ArrayList<Planta> plantas;
    ArrayList<lista_holder> holders;
    int cont;
    Boolean flag;
    int redColor = Color.RED;


    public Adapter_list(Context context, int layout_list, ArrayList<Planta> plantas) {

        super(context, layout_list, plantas);

        this.context = context;
        this.layout_list = layout_list;

        if(plantas.isEmpty()) this.plantas = new ArrayList<>();
        else this.plantas = plantas;

        holders = new ArrayList<lista_holder>();

    }

    public View getView(int posicion, View vista, ViewGroup parent) {


            View row = vista;
            lista_holder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layout_list, parent, false);

                holder = new lista_holder();

                holder.name = (TextView) row.findViewById(R.id.text_1);
                holder.date = (LinearLayout) row.findViewById(R.id.parametros);
                holder.ubic = (TextView) row.findViewById(R.id.ubic);
                holder.etapa= (TextView) row.findViewById(R.id.etapa);
                holder.datoTemp = (TextView) row.findViewById(R.id.temp);
                holder.datoHum = (TextView) row.findViewById(R.id.hum);
                holder.datoLuz = (TextView) row.findViewById(R.id.luz);
                holder.datoHormona = (TextView) row.findViewById(R.id.hormonas);


                row.setTag(holder);

            } else {
                holder = (lista_holder) row.getTag();
            }

            if(!plantas.isEmpty()) {

                Planta planta = plantas.get(posicion);

                holder.name.setText(planta.getNombre());
                holder.ubic.setText("Ubicacion: " + String.valueOf(planta.getUbicacion()));
                holder.etapa.setText("Etapa: " + planta.getEtapaActual().getNumetapa());

                holder.datoTemp.setText("Temperatura: " + Integer.toString(planta.getEtapaActual().getTempMin()) + " / " + Integer.toString(((Planta) planta).getTempActual()) + " / " + Integer.toString(planta.getEtapaActual().getTempMax()) + "  °C");
                if (!planta.tempCorrecta()) holder.datoTemp.setTextColor(Color.RED);
                else holder.datoTemp.setTextColor(Color.GRAY);


                holder.datoHum.setText("Humedad: " + Integer.toString(planta.getEtapaActual().getHumMin()) + " / " + Integer.toString(((Planta) planta).getHumedadActual()) + " / " + Integer.toString(planta.getEtapaActual().getHumMax()) + " %");
                if (!planta.humCorrecta()) holder.datoHum.setTextColor(Color.RED);
                else holder.datoHum.setTextColor(Color.GRAY);

                holder.datoLuz.setText("Luz: " + Integer.toString(planta.getEtapaActual().getLuzMin()) + " / " + Integer.toString(((Planta) planta).getLuzActual()) + " / " + Integer.toString(planta.getEtapaActual().getLuzMax()));
                if (!planta.luzCorrecta()) holder.datoLuz.setTextColor(Color.RED);
                else holder.datoHum.setTextColor(Color.GRAY);

                holder.datoHormona.setText("Hormona: " + Integer.toString(planta.getEtapaActual().getHormona()) + " / " + Integer.toString(((Planta) planta).getHormona()));

                holders.add(holder);
            }
            return row;
        }





    public void cambiarVisibilidad(int posicion)
    {
        if(holders.get(posicion).date.getVisibility()== View.VISIBLE)
        {
            holders.get(posicion).date.setVisibility( View.GONE);

        }
        else
        {


            holders.get(posicion).date.setVisibility( View.VISIBLE);
        }

    }

    public void addPlantas(Planta planta) {
        plantas.add(planta);

        notifyDataSetChanged();
    }

    public void RemovePlanta( int ubicacion)
    {
        plantas.remove(ubicacion);
        resetear();
    }

    public void addPlantas (ArrayList<Planta> arrayPlantas)
    {
        plantas.clear();
        plantas.addAll(arrayPlantas);
        notifyDataSetChanged();
    }

    public void resetear()
    {
        notifyDataSetChanged();
    }






    static class lista_holder
    {
        TextView name;
        LinearLayout date;
        TextView ubic;
        TextView etapa;
        TextView datoTemp;
        TextView datoHum;
        TextView datoLuz;
        TextView datoHormona;

        TextView ubicacion;
    }}
