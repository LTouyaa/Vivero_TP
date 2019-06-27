package com.TP.Vivero.Vista.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.TP.Vivero.Adapter.Adapter_list;
import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;
import com.TP.Vivero.Vista.Activity.MainMenuActivity;

import java.util.ArrayList;

import static com.TP.Vivero.R.layout.lista_plantas;

public class PlantadasFragment extends Fragment {

    Context context;
    ListView listaPlantas;
    Adapter_list adapter;
    MainMenuActivity mainMenuActivity;

    Controller controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregar, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        mainMenuActivity= (MainMenuActivity) context;

        ArrayList<Planta> plantadas;
//
//        if(mainMenuActivity.getModelo().getAllPlantadas()==null) plantadas = new ArrayList<>();
//        else plantadas =  mainMenuActivity.getModelo().getAllPlantadas();

//            if(controller.getModelo().getAllPlantadas()==null) plantadas = new ArrayList<>();
//            else plantadas = controller.getModelo().getAllPlantadas();

            adapter = new Adapter_list(context, lista_plantas, controller.getModelo().getAllPlantadas());
            listaPlantas = (ListView) getView().findViewById(R.id.listaView);
            listaPlantas.setAdapter(adapter);
            listaPlantas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    adapter.cambiarVisibilidad(position);
                }
            });

    }

    public Adapter_list getAdapter() {
        return adapter;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}


