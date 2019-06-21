package com.TP.Vivero.Vista.Fragment;

import android.R.layout;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;

import java.security.PublicKey;

import static android.R.*;
import static android.R.layout.simple_expandable_list_item_1;
import static android.R.layout.simple_spinner_dropdown_item;
import static com.TP.Vivero.R.layout.lista_plantas;
import static com.TP.Vivero.R.layout.support_simple_spinner_dropdown_item;

public class AgregarFragment extends Fragment {

    public Context context;
    ListView listaPlantas;

    public Planta[] plantadas = new Planta[]{
            new Planta( "Rosa", 23, 34, 21,23,34),
            new Planta( "Albahaca", 35, 34, 21,23,34),
            new Planta( "Rucula", 36, 34, 21,23,34),
            new Planta( "Rosa2", 45, 34, 21,23,34),
            new Planta( "Margarita", 23, 65, 21,23,34),
            new Planta( "Lechuga", 23, 34, 21,23,34),
            new Planta( "Tomate", 23, 34, 34,23,34),
            new Planta( "Acelga", 30, 34, 21,23,34),
            new Planta( "Rucula2", 23, 34, 21,0,12),
            new Planta( "Rosa3", 25, 34, 21,23,34),
            new Planta( "Rosa blanca", 23, 34, 21,23,34),
            new Planta( "Romero", 23, 34, 21,23,34),



            

    };



    public AgregarFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {





        return inflater.inflate( R.layout.fragment_agregar, container, false);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        listaPlantas = (ListView) getView().findViewById(R.id.listaPlantas);

        Adapter_list adapter = new Adapter_list(context, lista_plantas, plantadas);

        listaPlantas.setAdapter(adapter);

        listaPlantas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                adapter.cambiarVisibilidad(position);
            }
        });








    }
}
