package com.TP.Vivero.Vista.Fragment;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Model.PasoTiempoModel;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;

public class MenuFragment extends Fragment implements View.OnClickListener {

    private Button button;

    private Controller controller;
    private PasoTiempoModel pasoTiempoModel;

    public void setController(Controller controller){
        this.controller = controller;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pasoTiempoModel = new PasoTiempoModel(controller);

        button = view.findViewById(R.id.buton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pasoTiempoModel.pasar();

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
