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

import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.Object.PlantaAnual;
import com.TP.Vivero.Object.PlantaPerenne;
import com.TP.Vivero.R;

import java.security.PublicKey;
import java.util.ArrayList;

import static android.R.*;
import static android.R.layout.simple_expandable_list_item_1;
import static android.R.layout.simple_spinner_dropdown_item;
import static com.TP.Vivero.R.layout.lista_plantas;
import static com.TP.Vivero.R.layout.support_simple_spinner_dropdown_item;

public class AgregarFragment extends Fragment {

    public Context context;
    ListView listaPlantas;

    public Etapa etapa;
    public ArrayList<Planta> plantadas ;
    public Planta p1;
    public Planta p2;
    public DatabaseHandler bd;







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

        bd = new DatabaseHandler(context);
        p1 = new PlantaPerenne("01");
        p2= new PlantaAnual("02");
        p1.setNombre("p1");
        bd.savePlanta(p1);
        p2.setNombre("p2");
        bd.savePlanta(p2);
        bd.savePlantadas(p1);
        bd.savePlantadas(p2);
        etapa = new Etapa("p1",2,3,4,7,3,47,2,5,3);
        bd.saveEtapa(etapa);
        ArrayList<Etapa> allEtapa= (ArrayList) bd.getAllEtapa();
        plantadas = (ArrayList) bd.getAllPlantada();

        for (Planta planta : plantadas)
        {
            planta.agregarEtapa(allEtapa.get(0));
        }







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
