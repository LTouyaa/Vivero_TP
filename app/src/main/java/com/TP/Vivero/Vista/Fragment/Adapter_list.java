package com.TP.Vivero.Vista.Fragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.TP.Vivero.R;

import java.util.ArrayList;

public class Adapter_list extends ArrayAdapter<Plantas> {

    Context context;
    int layout_list;
    Plantas[] plantas;
    ArrayList<lista_holder> holders;
    int cont;
    Boolean flag;

    public Adapter_list(Context context, int layout_list, Plantas[] plantas)
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
            holder.date = (TextView) row.findViewById(R.id.text_2);

            row.setTag(holder);

        }
        else
        {holder = (lista_holder) row.getTag();
        }

        Plantas planta  = plantas[posicion];
        holder.name.setText(planta.nombre);
        holder.date.setText(planta.dato);
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
        TextView date;
    }




}
