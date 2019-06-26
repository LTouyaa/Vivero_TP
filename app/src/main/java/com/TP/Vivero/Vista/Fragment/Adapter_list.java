package com.TP.Vivero.Vista.Fragment;

import android.app.Activity;
import android.content.Context;
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

public class Adapter_list extends ArrayAdapter<Planta> {

    Context context;
    int layout_list;
    ArrayList<Planta> plantas;
    ArrayList<lista_holder> holders;
    int cont;
    Boolean flag;

    public Adapter_list(Context context, int layout_list, ArrayList<Planta> plantas)
    {
        super(context,layout_list,plantas);

        this.context=context;
        this.layout_list = layout_list;
        this.plantas = plantas;
        holders = new ArrayList<lista_holder>();
        flag= false;
    }

    public View getView (int posicion, View vista, ViewGroup parent)
    {
        View row = vista;
        lista_holder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layout_list, parent,false);

            holder = new lista_holder();
            holder.name = (TextView) row.findViewById(R.id.text_1);
            holder.date = (LinearLayout) row.findViewById(R.id.parametros);
            holder.datoTemp = (TextView)  row.findViewById(R.id.temp) ;
            holder.datoHum = (TextView) row.findViewById(R.id.hum) ;
            holder.datoLuz = (TextView) row.findViewById(R.id.luz) ;
            holder.datoHormona = (TextView) row.findViewById(R.id.hormonas) ;
            holder.datoSustrato = (TextView) row.findViewById(R.id.sustrato) ;


            row.setTag(holder);

        }
        else
        {holder = (lista_holder) row.getTag();
        }




        Planta planta  = plantas.get(posicion);
        Etapa etapaActual = planta.getEtapas().get(0);

        holder.name.setText(((Planta) planta).getNombre());
        holder.datoTemp.setText("Temperatura: "+Integer.toString(etapaActual.getTempMin())+" - "+Integer.toString(((Planta) planta).getTempActual())+" - "+Integer.toString(etapaActual.getTempMax())+"  °C");
        holder.datoHum.setText("Humedad: "+Integer.toString(etapaActual.getHumMin())+" - "+Integer.toString(((Planta)  planta).getHumedadActual())+" - "+Integer.toString(etapaActual.getHumMax())+" %");
        holder.datoLuz.setText("Luz: "+Integer.toString(etapaActual.getLuzMin())+" - "+Integer.toString(((Planta) planta).getLuzActual())+ " - "+Integer.toString(etapaActual.getLuzMin()));
        holder.datoHormona.setText("Hormona: "+Integer.toString(etapaActual.getHormona())+" - "+Integer.toString(((Planta) planta).getHormona()));
        holder.datoSustrato.setText("Sustrato: "+Integer.toString(etapaActual.getSustrato())+" - "+Integer.toString(((Planta) planta).getSustrato()));

        holders.add(holder);


        return row;
    }



    public void cambiarVisibilidad(int posicion)
    {
        if(!flag)
        {
            holders.get(posicion).date.setVisibility( View.VISIBLE);
            flag = true;
        }
        else
        {
            flag= false;
            holders.get(posicion).date.setVisibility( View.GONE);
        }

    }


    static class lista_holder
    {

        TextView name;
        LinearLayout date;
        TextView datoTemp;
        TextView datoHum;
        TextView datoLuz;
        TextView datoHormona;
        TextView datoSustrato;


    }




}
