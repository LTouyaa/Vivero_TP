package com.TP.Vivero.Vista.Fragment;

import android.R.layout;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.TP.Vivero.R;

import static android.R.*;
import static android.R.layout.simple_expandable_list_item_1;
import static android.R.layout.simple_spinner_dropdown_item;
import static com.TP.Vivero.R.layout.lista_plantas;
import static com.TP.Vivero.R.layout.support_simple_spinner_dropdown_item;

public class AgregarFragment extends Fragment {

    public Context context = getActivity();
    public ListView listaPlantas;
    public Plantas[] plantadas = new Plantas[]{
            new Plantas("Planta1", "Dato1"),
            new Plantas("Planta2","Dato2")
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

        listaPlantas = (ListView) getView().findViewById(R.id.listaPlantas);

        Adapter_list adapter = new Adapter_list(context, lista_plantas, plantadas);

        listaPlantas.setAdapter(adapter);







    }
}
